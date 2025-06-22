import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MOD = 1000000000;
        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0];
        int K = NK[1];

        int[][] dp = new int[K+1][N+1];
        Arrays.fill(dp[1], 1);
        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }

        for(int i = 2 ; i <= K ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                dp[i][j] %= MOD;
            }
        }

        System.out.println( dp[K][N]);
    }
}
