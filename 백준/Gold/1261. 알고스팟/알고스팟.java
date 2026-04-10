import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int M,N;
    static int[][] arr;

    static int[] dy = new int[]{0, 0, 1, -1};
    static int[] dx = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            int j = 0;
            for (char c : br.readLine().toCharArray()) {
                arr[i][j++] = c - '0';
            }
        }

        // 0-1 BFS
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        dq.offer(new int[]{0, 0, 0});

        while (!dq.isEmpty()) {
            int[] p = dq.pollFirst();

            int y = p[0], x = p[1], wall = p[2];
            if (y == N - 1 && x == M - 1) {
                System.out.println(wall);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d], nx = x + dx[d];
                if (range(ny, nx) && !visited[ny][nx]) {
                    // 벽이면 1가중치
                    if (arr[ny][nx] == 1) {
                        dq.offerLast(new int[]{ny, nx, wall + 1});
                    }else{
                        dq.offerFirst(new int[]{ny, nx, wall});
                    }
                    visited[ny][nx] = true;
                }
            }

        }


    }

    private static boolean range(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}