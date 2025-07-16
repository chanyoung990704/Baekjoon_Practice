import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static class Path {
        int s;
        int e;
        int cnt;

        public Path(int s, int e, int cnt) {
            this.s = s;
            this.e = e;
            this.cnt = cnt;
        }
    }

    static int[] parent;

    static int findParent(int x){
        if(parent[x] != x){
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y){
        x = findParent(x);
        y = findParent(y);

        if(x < y){
            parent[y] = x;
        }else{
            parent[x] = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N;  j++) {
                if (map[i][j] == 'S' || map[i][j] == 'K') {
                    list.add(new Node(i, j));
                }
            }
        }

        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
        for (int i = 0; i < list.size(); i++) {
            bfs(i, list, map, pq);
        }

        parent = new int[list.size()];
        for(int i = 0 ; i < parent.length ; i++){
            parent[i] = i;
        }

        int cnt = 0;
        int sum = 0;

        while(!pq.isEmpty()){
            Path p = pq.poll();
            if(findParent(p.s) != findParent(p.e)){
                union(p.s, p.e);
                sum += p.cnt;
                cnt++;
            }
        }

        if(cnt == list.size() - 1){
            System.out.println(sum);
        }else{
            System.out.println(-1);
        }
    }

    private static void bfs(int i, List<Node> list, char[][] map, PriorityQueue<Path> pq) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Node start = list.get(i);
        visited[start.y][start.x] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start.y, start.x, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int cnt = cur[2];

            int[] dy = new int[]{1, -1, 0, 0};
            int[] dx = new int[]{0, 0, -1, 1};

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) {
                    continue;
                }

                if (!visited[ny][nx] && map[ny][nx] != '1') {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx, cnt + 1});
                    if(map[ny][nx] != '0'){
                        for(int j = 0 ; j < list.size() ; j++){
                            if(list.get(j).y == ny && list.get(j).x == nx){
                                pq.offer(new Path(i, j, cnt + 1));
                            }
                        }
                    }
                }
            }
        }
    }
}