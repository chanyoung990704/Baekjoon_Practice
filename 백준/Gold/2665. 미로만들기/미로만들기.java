import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    static int[][] grid;
    static int R, C;

    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        R = C = N;
        grid = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = str.charAt(j) - '0';
            }
        }


        // 0-1 BFS
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        visited[0][0] = true;
        dq.offerFirst(new int[]{0, 0, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1], cnt = cur[2];

            if (r == R - 1 && c == C - 1) {
                System.out.println(cnt);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (range(nr, nc) && !visited[nr][nc]) {
                    if (grid[nr][nc] == 0) {
                        dq.offerLast(new int[]{nr, nc, cnt + 1});
                    }else{
                        dq.offerFirst(new int[]{nr, nc, cnt});
                    }
                    visited[nr][nc] = true;
                }
            }
        }

    }

    private static boolean range(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}