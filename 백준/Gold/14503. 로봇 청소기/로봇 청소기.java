import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1}; // 북, 동, 남, 서

    static int y, x, dir;
    static int[][] arr;
    static boolean[][] clean;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        clean = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            // 현재 칸 청소
            clean[y][x] = true;

            boolean blocked = true;
            int nextDir = dir;
            // 주변 4칸 반시계 탐색
            for (int d = 0; d < 4; d++) {
                nextDir = (nextDir + 3) % 4;
                // 청소되지 않은 빈 칸인 경우 한칸 전진
                int ny = y + dy[nextDir];
                int nx = x + dx[nextDir];

                if (range(ny, nx) && !clean[ny][nx] && arr[ny][nx] == 0) {
                    blocked = false;
                    y = ny;
                    x = nx;
                    dir = nextDir;
                    break;

                }
            }

            // 청소되지 않은 빈칸이 없는 경우
            if (blocked) {
                // 바라보는 방향 유지한 채로 한칸 후진
                int ny = y - dy[dir];
                int nx = x - dx[dir];

                // 후진 가능하면
                if (range(ny, nx) && arr[ny][nx] != 1) {
                    y = ny;
                    x = nx;
                }else{
                    break;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (clean[i][j]) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }

    static boolean range(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

}
