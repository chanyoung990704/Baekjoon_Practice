import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[][] map;

    static int min = 987654321;
    static List<CCTV> cctvs = new ArrayList<>();

    static class CCTV {
        int y, x, type;
        CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    // 상 우 하 좌
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    // dirs[type] = 가능한 방향 조합들
    static int[][][] dirs = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3}},
            {{0, 1, 2, 3}}
    };


    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);

        System.out.println(min);

    }

    private static void dfs(int idx, int[][] map) {
        // basecase
        if (idx == cctvs.size()) {
            min = Math.min(min, countBlind(map));
            return;
        }

        CCTV cur = cctvs.get(idx);

        for (int[] dirSet : dirs[cur.type]) {
            int[][] copied = copyMap(map);
            for (int dir : dirSet) {
                watch(cur.y, cur.x, dir, copied);
            }
            dfs(idx+1, copied);
        }
    }

    private static void watch(int y, int x, int dir, int[][] copied) {
        int ny = y, nx = x;

        while (true) {
            ny += dy[dir];
            nx += dx[dir];

            if (!isRange(ny, nx) || copied[ny][nx] == 6) {
                break;
            }

            if (copied[ny][nx] == 0) {
                copied[ny][nx] = -1;
            }

        }
    }

    private static int countBlind(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copied = new int[N][M];
        for (int i = 0; i < N; i++) {
            copied[i] = Arrays.copyOf(map[i], M);
        }
        return copied;
    }

    static boolean isRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}