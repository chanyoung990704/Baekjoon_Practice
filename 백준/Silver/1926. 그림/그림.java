import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> nm = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int n = nm.get(0);
        int m = nm.get(1);

        int[][] graph = new int[n][m];
        for(int i = 0 ; i < n;  i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j < input.length ; j++){
                graph[i][j] = Integer.valueOf(input[j]);
            }
        }

        // BFS
        int cnt = 0;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(graph[i][j] == 1){
                    int cur = 0;// 땅 크기
                    Deque<List<Integer>> dq = new ArrayDeque<>();
                    dq.offer(List.of(i, j));
                    graph[i][j] = 0;
                    cur++;
                    // bfs 진행
                    while (!dq.isEmpty()) {
                        List<Integer> c = dq.pollFirst();
                        int y = c.get(0);
                        int x = c.get(1);

                        int[] dy = new int[]{0,0,1,-1};
                        int[] dx = new int[]{1,-1,0,0};
                        for(int dir = 0 ; dir < 4 ; dir++){
                            int ny = y + dy[dir];
                            int nx = x + dx[dir];

                            if(ny >= 0 && ny < n && nx >= 0 && nx < m){
                                if(graph[ny][nx] == 1){
                                    graph[ny][nx] = 0;
                                    cur++;
                                    dq.offer(List.of(ny, nx));
                                }
                            }
                        }
                    }
                    // 값 갱신
                    max = Math.max(max, cur);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }
}

