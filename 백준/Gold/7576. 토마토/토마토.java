import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int M, N;

    static int[][] arr;

    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 토마토  큐에 넣기
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                // 익은 토마토는 큐에 넣기
                if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }else if(arr[i][j] == 0){
                    cnt++;
                }
            }
        }

        // 처음부터 모두 익어있는 경우
        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1], day = cur[2];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d], nx = x + dx[d];
                if (range(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    cnt--;
                    if (cnt == 0) {
                        System.out.println(day + 1);
                        return;
                    }
                    q.offer(new int[]{ny, nx, day + 1});
                }
            }
        }


        System.out.println(-1);
    }

    private static boolean range(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
