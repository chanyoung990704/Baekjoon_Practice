import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i < N; i++) {
            dp[0][1 << i] = cost[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int cur = 0; cur < (1 << N); cur++) {
                // 현재 불가능 마스킹
                if (dp[i - 1][cur] == INF) {
                    continue;
                }

                for (int j = 0; j < N; j++) {
                    // 다음 할당 작업
                    if (((cur >> j) & 1) > 0) {
                        continue;
                    }
                    int next = cur | (1 << j);
                    dp[i][next] = Math.min(dp[i][next], dp[i - 1][cur] + cost[i][j]);
                }
            }
        }

        System.out.println(dp[N - 1][(1 << N) - 1]);

    }

}
