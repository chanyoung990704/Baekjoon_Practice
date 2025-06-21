import java.io.*;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 동 서 남 북
        int[] dy = new int[] {0, 0, 1, -1};
        int[] dx = new int[] {1, -1, 0, 0};
        int[][][] move = new int[][][]{
                // 1번
                {
                        {0},{1},{2},{3}
                },
                // 2번
                {
                        {0,1},{2,3}
                },
                // 3번
                {
                        {3,0},{0,2},{2,1},{1,3}
                },
                // 4번
                {
                        {3,0,1},{0,2,3},{2,0,1},{1,2,3}
                },
                // 5번
                {
                        {0,1,2,3}
                }
        };

        List<int[]> idxs = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] >= 1 && map[i][j] <= 5) { // 수정: 범위 체크 추가
                    idxs.add(new int[]{i, j});
                }
            }
        }

        bruteForce(0, move, idxs, dy, dx, map);

        System.out.println(min);
    }

    private static void bruteForce(int i, int[][][] move, List<int[]> idxs, int[] dy, int[] dx, int[][] map) {
        if (i == idxs.size()) {
            int cnt = 0;
            for(int y = 0; y < map.length; y++) {
                for(int x = 0; x < map[0].length; x++) {
                    if(map[y][x] == 0) {
                        cnt++;
                    }
                }
            }
            min = Math.min(min, cnt);
            return;
        }

        int y = idxs.get(i)[0];
        int x = idxs.get(i)[1];
        int val = map[y][x] - 1;

        // 수정: 배열 범위 체크 추가
        if(val < 0 || val >= move.length) {
            return;
        }

        for(int[] m : move[val]){
            int[][] backup = copyArr(map);

            for(int j = 0; j < m.length; j++) {
                int ny = y;
                int nx = x;
                while (true) {
                    ny += dy[m[j]];
                    nx += dx[m[j]];

                    if (!isBoundary(map, ny, nx) || map[ny][nx] == 6) {
                        break;
                    }

                    if(map[ny][nx] == 0) { // 수정: 빈 공간만 감시 처리
                        map[ny][nx] = 7;
                    }
                }
            }

            bruteForce(i+1, move, idxs, dy, dx, map);

            // 복원
            for(int r = 0; r < map.length; r++) {
                for(int c = 0; c < map[0].length; c++) {
                    map[r][c] = backup[r][c];
                }
            }
        }
    }

    private static int[][] copyArr(int[][] map) {
        int[][] copied = new int[map.length][map[0].length];
        for(int i = 0; i < map.length; i++) {
            copied[i] = Arrays.copyOf(map[i], map[i].length);
        }
        return copied;
    }

    private static boolean isBoundary(int[][] map, int ny, int nx) {
        return ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length;
    }
}
