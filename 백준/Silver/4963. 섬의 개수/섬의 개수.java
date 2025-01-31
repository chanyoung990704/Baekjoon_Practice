import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 기존 코드 유지 (입력 및 날짜 처리 부분)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        while (true) {
            List<Integer> wh = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
    
            int w = wh.get(0);
            int h = wh.get(1);
            if(w == 0 && h == 0){
                break;
            }     

            int[][] arr = new int[h][w];
            for(int i = 0 ; i < h ; i++){
                String[] str = br.readLine().split(" ");
                for(int j = 0 ; j < str.length ; j++){
                    int val = Integer.valueOf(str[j]);
                    arr[i][j] = val;
                }
            }

            // BFS
            boolean[][] visited = new boolean[h][w];
            int cnt = 0;
            for(int i = 0 ; i < h ; i++){
                for(int j = 0 ; j < w ; j++){
                    if(!visited[i][j] && arr[i][j] == 1){
                        // BFS 진행
                        bfs(visited, arr, i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void bfs(boolean[][] visited, int[][] arr, int i, int j){
        visited[i][j] = true;
        Deque<List<Integer>> dq = new ArrayDeque<>();
        dq.offer(List.of(i, j));

        while (!dq.isEmpty()) {
            List<Integer> cur = dq.pollFirst();

            int[] dy = new int[]{0,0,1,-1,-1,1,1,-1};
            int[] dx = new int[]{1,-1,0,0,1,1,-1,-1};

            for(int dir = 0 ; dir < dy.length ; dir++){
                int ny = cur.get(0) + dy[dir];
                int nx = cur.get(1) + dx[dir];

                if(ny >= 0 && ny < arr.length && nx >= 0 && nx < arr[0].length){
                    if(!visited[ny][nx] && arr[ny][nx] == 1){
                        visited[ny][nx] = true;
                        dq.offer(List.of(ny, nx));
                    }
                }
            }
        }
    }
}
