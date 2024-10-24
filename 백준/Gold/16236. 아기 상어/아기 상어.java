import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static List<List<Integer>> adj = new ArrayList<>();
    static int sy, sx;
    static int N;
    static int level = 2;
    static int feed = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++) adj.add(Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new)));

        // 아기상어 idx 찾기
        for(int i = 0 ; i < N ; i++)
            for(int j = 0 ; j < N ; j++)
                if(adj.get(i).get(j) == 9){
                    sy = i;
                    sx = j;
                    adj.get(i).set(j, 0);
                }

        
        int time = 0;
        while (true) {
            int weight = canFeed(bfs());
            // 먹을 수 없는 경우
            if(weight == -1) break;

            feed++;
            if(level == feed){
                level++;
                feed = 0;
            }
            time += weight;
        }


        System.out.println(time);
        br.close();
    }

    static int canFeed(int[][] dist){
        int max = Integer.MAX_VALUE;
        int y = -1;
        int x = -1;
        for(int i = 0 ; i < N ; i++)
            for(int j = 0 ; j < N ; j++){
                int target = adj.get(i).get(j);
                if(target > 0 && target < level && dist[i][j] != -1 && dist[i][j] < max) {
                    max = Math.min(max, dist[i][j]);
                    y = i;
                    x = j;
                }
            }
        
        if (max == Integer.MAX_VALUE) return -1;
        
        adj.get(y).set(x, 0);
        sy = y;
        sx = x;
        return max;
    }

    static int[][] bfs(){
        int[][] dist = new int[N][N];
        for(int i = 0 ; i < N ; i++) Arrays.fill(dist[i], -1);
        dist[sy][sx] = 0;
        Deque<List<Integer>> dq = new ArrayDeque<>();
        dq.offer(List.of(sy, sx));

        while (!dq.isEmpty()) {
            List<Integer> cur = dq.poll();
            int y = cur.get(0);
            int x = cur.get(1);

            int[] dy = new int[]{0,0,1,-1};
            int[] dx = new int[]{1,-1,0,0};
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(isBoundary(ny, nx) && dist[ny][nx] == -1 && adj.get(ny).get(nx) <= level){
                    dist[ny][nx] = dist[y][x] + 1;
                    dq.offer(List.of(ny, nx));
                }
            }
        }
        


        return dist;
    }

    static boolean isBoundary(int y, int x){
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}