import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static final int MOD = 1000000000;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        long[][][] dp = new long[N + 1][10][1 << 10];

        for (int j = 1; j <= 9; j++) {
            dp[1][j][1 << j] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int b = 0; b < (1 << 10); b++) {
                    if (dp[i][j][b] == 0) {
                        continue;
                    }

                    int next = 0;
                    if (j > 0) {
                        next = b | (1 << (j - 1));
                        dp[i + 1][j - 1][next] = (dp[i + 1][j - 1][next] + dp[i][j][b]) % MOD;
                    }
                    if (j < 9) {
                        next = b | (1 << (j + 1));
                        dp[i + 1][j + 1][next] = (dp[i + 1][j + 1][next] + dp[i][j][b]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (int j = 0; j <= 9; j++) {
            ans = (ans + dp[N][j][(1 << 10) - 1]) % MOD;
        }
        System.out.println(ans);

    }

}
