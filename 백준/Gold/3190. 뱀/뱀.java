import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int M, N;

    static int[][] arr;

    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};

    static int y, x,dir, len;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        int K = Integer.parseInt(br.readLine());
        // 사과 위치
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
        }

        // 뱀의 방향 변환 정보
        int L = Integer.parseInt(br.readLine());
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            if (d.equals("D")) {
                q.offer(new int[]{t, 0});
            }
            if (d.equals("L")) {
                q.offer(new int[]{t, 1});
            }
        }

        y = x = 0;
        dir = 1;
        len = 1;

        Deque<int[]> snake = new ArrayDeque<>();
        snake.offerFirst(new int[]{0, 0});
        arr[0][0] = 1; // 뱀의 몸은 1, 사과는 2

        while (true) {
            time++;

            // 몸길이 늘린다
            int ny = y + dy[dir], nx = x + dx[dir];
            if (!range(ny, nx) || arr[ny][nx] == 1) {
                break;
            }
            // 이동한 칸이 사과인지
            if (arr[ny][nx] != 2) { // 사과 없다면
                int[] tail = snake.pollLast();
                arr[tail[0]][tail[1]] = 0;
            }

            // 머리 이동
            arr[ny][nx] = 1;
            snake.offerFirst(new int[]{ny, nx});
            y = ny;
            x = nx;

            // 방향 전환
            if (!q.isEmpty() && q.peek()[0] == time) {
                int[] turn = q.poll();
                if (turn[1] == 0) dir = (dir + 1) % 4; // 시계
                else dir = (dir + 3) % 4;             // 반시계
            }
        }

        System.out.println(time);

    }

    private static boolean range(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
