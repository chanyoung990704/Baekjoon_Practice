import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[][] matrices = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrices[i][0] = Integer.parseInt(st.nextToken()); // row
            matrices[i][1] = Integer.parseInt(st.nextToken()); // col
        }

        int[][] dp = new int[N + 1][N + 1];

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i < N; i++) {
                int j = i + len -1;
                if (j >= N) {
                    break;
                }

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + (matrices[i][0] * matrices[k][1] * matrices[j][1]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[0][N - 1]);

    }

}
