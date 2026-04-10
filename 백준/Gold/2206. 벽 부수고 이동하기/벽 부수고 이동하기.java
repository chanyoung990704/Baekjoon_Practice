import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] grid;
    static int R, C;

    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new int[R][C];

        for (int i = 0; i < R; i++) {
            int idx = 0;
            for (char ch : br.readLine().toCharArray()) {
                grid[i][idx++] = ch - '0';
            }
        }

        int sr = 0, sc = 0;
        int er = R-1, ec = C-1;


        boolean[][][] visited = new boolean[R][C][2];
        visited[sr][sc][0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc, 0, 0}); // r c 벽 비트, 총 이동겨리

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0], c = p[1], wall = p[2], cnt = p[3];

            if (r == er && c == ec) {
                System.out.println(cnt+1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (range(nr, nc)) {
                    // 다음칸이 벽
                    if (grid[nr][nc] == 1 && wall == 0 && !visited[nr][nc][1]) {
                        visited[nr][nc][1] = true;
                        q.offer(new int[]{nr, nc, 1, cnt + 1});
                    }

                    // 다음칸 벽 아님
                    if (grid[nr][nc] == 0 && !visited[nr][nc][wall]) {
                        visited[nr][nc][wall] = true;
                        q.offer(new int[]{nr, nc, wall, cnt + 1});
                    }
                }
            }

        }



        System.out.println(answer);
    }

    private static boolean range(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }


}