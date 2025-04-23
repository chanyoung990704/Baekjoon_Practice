import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N L R
        int[] NLR = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NLR[0];
        int L = NLR[1];
        int R = NLR[2];

        // DP
        long[][][] dp = new long[N+1][L+1][R+1];
        // 1개 있을 때는 값이 1
        dp[1][1][1] = 1;

        int MOD = 1000000007;

        for(int i = 2 ; i <= N ; i++){
            for(int j = 1 ; j <= L ; j++){
                for(int k = 1 ; k <= R ; k++){
                    dp[i][j][k] = (dp[i-1][j-1][k] % MOD)  + (dp[i-1][j][k-1] % MOD) + (dp[i-1][j][k] * (i-2) % MOD);
                    dp[i][j][k] %= MOD;
                }
            }
        }

        System.out.println(dp[N][L][R]);
    }
}
