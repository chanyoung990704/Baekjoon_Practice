import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int R, C, T;

    static int[][] map;

    static int[][] airConditional = new int[2][2];
    static int ret = 0; // 남아있는 미세먼지 양

    static int[] dy = new int[]{0, 0, 1, -1};
    static int[] dx = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // map init
        map = new int[R][C];
        int ac = 0;
        for (int i = 0; i < R; i++) {
            map[i] = Arrays.stream(br.readLine().split("\\s"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    airConditional[ac][0] = i;
                    airConditional[ac][1] = j;
                    ac++;
                }
            }
        }

        // T초
        while (T-- > 0) {
            // 미세먼지 확산
            dust();

            // 공청기 작동
            airCon();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    ret+=map[i][j];
                }
            }
        }
        System.out.println(ret);
    }

    private static void airCon() {
        // 맵 복사
        int[][] cMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            cMap[i] = Arrays.copyOf(map[i], map[i].length);
        }

        // 위쪽 에어컨
        int y = airConditional[0][0], x = airConditional[0][1];
        int[] ddy = new int[]{0, -1, 0, 1};
        int[] ddx = new int[]{1, 0, -1, 0};

        // 시작점 초기화
        y += ddy[0];
        x += ddx[0];
        cMap[y][x] = 0;

        for (int d = 0; d < 4; d++) {
            while (true) {
                int ny = y + ddy[d], nx = x + ddx[d];
                // 범위 밖
                if (!boundary(ny, nx)) {
                    break;
                }
                if (map[ny][nx] == -1) {
                    break;
                }
                // 한칸씩 이동
                cMap[ny][nx] = map[y][x];
                y = ny;
                x = nx;
            }
        }

        // 아래쪽 에어컨
        y = airConditional[1][0];
        x = airConditional[1][1];
        ddy = new int[]{0, 1, 0, -1};
        ddx = new int[]{1, 0, -1, 0};

        y += ddy[0];
        x += ddx[0];
        cMap[y][x] = 0;

        for (int d = 0; d < 4; d++) {
            while (true) {
                int ny = y + ddy[d], nx = x + ddx[d];
                // 범위 밖
                if (!boundary(ny, nx)) {
                    break;
                }
                if (map[ny][nx] == -1) {
                    break;
                }
                // 한칸씩 이동
                cMap[ny][nx] = map[y][x];
                y = ny;
                x = nx;
            }
        }

        map = cMap;
    }

    private static void dust() {
        // 맵 복사
        int[][] cMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            cMap[i] = Arrays.copyOf(map[i], map[i].length);
        }
        // 인접 네방향 확산
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int y = i, x = j;
                // 현재가 미세먼지가 아니면 스킵
                if (map[i][j] == 0 || map[i][j] == -1) {
                    continue;
                }
                int cnt = 0; // 확산시킨 방
                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d], nx = x + dx[d];
                    // 범위 밖 또는 공청기
                    if (!boundary(ny, nx) || map[ny][nx] == -1) {
                        continue;
                    }

                    // 복사한 맵에 확산시키기
                    int nextDust = map[y][x] / 5;
                    cMap[ny][nx] += nextDust;
                    cnt++;
                }
                // 현재 미세먼지 양 감소
                cMap[y][x] -= cnt * (map[y][x] / 5);
            }
        }

        map = cMap;
    }

    private static boolean boundary(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}