import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[][] grid;
    static int R, C;

    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};

    static int sr, sc, er, ec;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 'S') {
                    sr = i; sc = j;
                } else if (grid[i][j] == 'E') {
                    er = i; ec = j;
                }
            }
        }

        boolean[][] isNear = new boolean[R][C];
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(grid[i][j] == '#') continue;
                for(int d=0; d<4; d++) {
                    int ni = i + dr[d], nj = j + dc[d];
                    if(ni >= 0 && ni < R && nj >= 0 && nj < C && grid[ni][nj] == '#') {
                        isNear[i][j] = true;
                        break;
                    }
                }
            }
        }

        int[][] dist = new int[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();
        dist[sr][sc] = 0;
        dq.offer(new int[]{sr, sc});

        while (!dq.isEmpty()) {
            int[] p = dq.pollFirst();
            int r = p[0], c = p[1];

            if (r == er && c == ec) {
                System.out.println(dist[r][c]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (range(nr, nc) && grid[nr][nc] != '#') {
                    int cost = (isNear[r][c] && isNear[nr][nc]) ? 0 : 1;
                    if (dist[nr][nc] > dist[r][c] + cost) {
                        dist[nr][nc] = dist[r][c] + cost;
                        if (cost == 0) dq.offerFirst(new int[]{nr, nc});
                        else dq.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    private static boolean range(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}