import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][2];
        int mod = 9901;

        dp[1][0] = 1;
        dp[1][1] = 2;

        for(int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % mod;
            dp[i][1] = (dp[i-1][0] * 2 + dp[i-1][1]) % mod;
        }

        System.out.println((dp[N][0] + dp[N][1]) % mod);

    }
}
