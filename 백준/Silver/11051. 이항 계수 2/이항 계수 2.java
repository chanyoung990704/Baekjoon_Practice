import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0];
        int K = NK[1];

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= Math.min(i, K); j++) {
                if (i == j || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
