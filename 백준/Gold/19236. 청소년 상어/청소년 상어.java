import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {


    static class Node{
        int idx;
        int dir;

        Node(int idx, int dir){
            this.idx = idx;
            this.dir = dir;
        }

        int idx(){return this.idx;}
        int dir(){return this.dir;}
    }
    static int[] dy = new int[]{-9,-1,-1,0,1,1,1,0,-1};
    static int[] dx = new int[]{-9,0,-1,-1,-1,0,1,1,1};
    static List<List<Node>> adj = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input
        for(int i = 0 ; i < 4 ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < 4 ; i++){
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0 ; j < inputs.length ; j += 2) adj.get(i).add(new Node(inputs[j], inputs[j + 1]));
        }

        System.out.println(run(adj, 0, 0));

        br.close();
    }

    static int run(List<List<Node>> adj, int sharkY, int sharkX){
        int sharkDir = adj.get(sharkY).get(sharkX).dir();
        int curVal = adj.get(sharkY).get(sharkX).idx();
        adj.get(sharkY).set(sharkX, new Node(-1, -1));

        // moving fishes
        List<List<Node>> copyAdj = deepCopy(adj);
        fishMove(copyAdj, sharkY, sharkX);

        // moving sharks
        int max = 0;
        List<List<Integer>> sharkPath = target(copyAdj, sharkY, sharkX, sharkDir);
        for(List<Integer> path : sharkPath){
            int ny = path.get(0);
            int nx = path.get(1);
            max = Math.max(max, run(deepCopy(copyAdj), ny, nx));
        }

        return max + curVal;
    }

    static List<List<Node>> deepCopy(List<List<Node>> adj){
        List<List<Node>> copyAdj = new ArrayList<>();
        for(List<Node> list : adj) copyAdj.add(new ArrayList<>(list));
        return copyAdj;       
    }


    static List<List<Integer>> target(List<List<Node>> adj, int sharkY, int sharkX, int sharkDir){
        List<List<Integer>> ret = new ArrayList<>();
        while(true){
            sharkY += dy[sharkDir];
            sharkX += dx[sharkDir];
            if(!isBoundary(sharkY, sharkX)) break;
            Node cur = adj.get(sharkY).get(sharkX);
            if(cur.idx() >= 1 && cur.idx() <= 16) ret.add(List.of(sharkY, sharkX));

        }
        return ret;
    }

    static void fishMove(List<List<Node>> adj, int sharkY, int sharkX){
        for(int i = 1 ; i <= 16 ; i++){
            int[] fishIdx = findFish(adj, i);
            if(fishIdx[0] == -1 && fishIdx[1] == -1) continue;
            int y = fishIdx[0];
            int x = fishIdx[1];
            int dir = adj.get(y).get(x).dir();
            int cnt = 0;

            while (cnt < 8) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if(isBoundary(ny, nx) && !(ny == sharkY && nx == sharkX)){
                    Node op = new Node(adj.get(ny).get(nx).idx(), adj.get(ny).get(nx).dir());
                    Node org = new Node(adj.get(y).get(x).idx(), dir);
                    adj.get(ny).set(nx, org);
                    adj.get(y).set(x, op);
                    break;
                }

                cnt++;
                dir++;
                if(dir == 9) dir = 1;
            }


        }
    }

    static int[] findFish(List<List<Node>> adj, int idx){
        
        for(int i = 0 ; i < 4 ; i++)
            for(int j = 0 ; j < 4 ; j++)
                if(adj.get(i).get(j).idx() == idx) return new int[]{i, j};

        return new int[]{-1, -1};
    }

    static boolean isBoundary(int y, int x){return y >= 0 && y < 4 && x >= 0 && x < 4;}


}