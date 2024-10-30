import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class Node{
        int idx;
        int dir;
        int t; // limit time

        Node(int idx, int dir, int t){
            this.idx = idx;
            this.dir = dir;
            this.t = t;
        }
    }

    static class NextShark{
        Node node;
        int y;
        int x;
        NextShark(Node node, int y, int x){
            this.node = node;
            this.y = y;
            this.x = x;
        }
    }

    // not use 0 idx
    static int[] dy = new int[]{-2, -1,1,0,0};
    static int[] dx = new int[]{-2, 0,0,-1,1};

    static List<List<Node>> adj = new ArrayList<>();
    static List<List<List<Integer>>> sharkDirs = new ArrayList<>();
    static int time = 0;
    static int k = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NMk = brToArr(br);
        k = NMk[2];

        Map<Integer, List<Integer>> sharkMap = new HashMap<>();
        Map<Integer, Integer> sharkDirMap = new HashMap<>();
        for(int i = 0 ; i < NMk[0] ; i++){
            int[] jArr = brToArr(br);
            adj.add(new ArrayList<>());
            for(int j = 0 ; j < NMk[0] ; j++){
                if(jArr[j] > 0) sharkMap.put(jArr[j], List.of(i, j));
                adj.get(i).add(new Node(0, 0, 0));
            }
        }

        int[] dirArr = brToArr(br);
        for(int i = 0 ; i < dirArr.length ; i++) sharkDirMap.put(i + 1, dirArr[i]);

        for(int i = 1 ; i <= NMk[1] ; i++){
            List<Integer> dir = sharkMap.get(i);
            int y = dir.get(0);
            int x = dir.get(1);
            adj.get(y).set(x, new Node(i, sharkDirMap.get(i), k));
        }

        for(int i = 0 ; i <= NMk[1] ; i++) sharkDirs.add(new ArrayList<>());
        for(int i = 1 ; i <= NMk[1] ; i++){
            sharkDirs.get(i).add(new ArrayList<>());
            for(int j = 0 ; j < 4 ; j++){
                sharkDirs.get(i).add(Arrays.stream(br.readLine().split(" "))
                                                     .map(Integer::valueOf)
                                                     .collect(Collectors.toList()));
            }
        }

        // start Logic
        while (true) {
            // basecase
            if(isOnlyOne()) break;
            if(time >= 1000) {
                time = -1;
                break;
            }

            moveShark();
            time++;
        }

        // print time
        System.out.println(time);
        br.close();
    }

    static void moveShark() {
        List<List<Integer>> sharkIdx = getSharkIdx();
        int N = adj.size();
        
        // 임시 맵 생성 및 초기화
        List<List<Node>> tempMap = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            tempMap.add(new ArrayList<>());
            for(int j = 0; j < N; j++) {
                Node currentNode = adj.get(i).get(j);
                // 기존 냄새 정보 복사 (시간은 1 감소)
                if(currentNode.t > 0) {
                    tempMap.get(i).add(new Node(currentNode.idx, currentNode.dir, currentNode.t - 1));
                } else {
                    tempMap.get(i).add(new Node(0, 0, 0));
                }
            }
        }

        for(List<Integer> shark : sharkIdx){
            Node cur = adj.get(shark.get(0)).get(shark.get(1));
            List<Integer> priority = sharkDirs.get(cur.idx).get(cur.dir);
            boolean isMoved = false;
            
            // 냄새가 없는 칸으로 이동 시도
            for(int d : priority){
                int ny = shark.get(0) + dy[d];
                int nx = shark.get(1) + dx[d];
                if(isBoundary(ny, nx) && adj.get(ny).get(nx).t == 0){
                    updateTempMap(tempMap, ny, nx, new Node(cur.idx, d, k));
                    isMoved = true;
                    break;
                }
            }
            
            // 자신의 냄새가 있는 칸으로 이동
            if(!isMoved){
                for(int d : priority){
                    int ny = shark.get(0) + dy[d];
                    int nx = shark.get(1) + dx[d];
                    boolean isFound = false;
                    if(isBoundary(ny, nx) && adj.get(ny).get(nx).idx == cur.idx){
                        updateTempMap(tempMap, ny, nx, new Node(cur.idx, d, k));
                        isFound = true;
                        break;
                    }
                    if(isFound) break;
                }
            }
        }

        // 임시 맵을 실제 맵으로 복사
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                adj.get(i).set(j, tempMap.get(i).get(j));
            }
        }
    }

    // 임시 맵 업데이트 메소드
    static void updateTempMap(List<List<Node>> tempMap, int y, int x, Node newNode) {
        Node existing = tempMap.get(y).get(x);
        if(existing.t == k) { 
            if(newNode.idx < existing.idx) { 
                tempMap.get(y).set(x, newNode);
            }
        } else {
            tempMap.get(y).set(x, newNode);
        }
    }

    static boolean isBoundary(int y, int x){
        return y >= 0 && y < adj.size() && x >= 0 && x < adj.size();
    }

    static List<List<Integer>> getSharkIdx() {
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0 ; i < adj.size() ; i++)
            for(int j = 0 ; j < adj.size() ; j++)
                if(adj.get(i).get(j).t == k) ret.add(List.of(i, j));
        return ret;
    }

    static int[] brToArr(BufferedReader br) throws IOException{
        return Arrays.stream(br.readLine().split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    static boolean isOnlyOne(){
        boolean ret = true;
        for(List<Node> l : adj)
            for(Node n : l)
                if(n.idx != 0 && n.idx != 1 && n.t == k) return false;
        return ret;
    }
}