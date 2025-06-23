import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[0] = 1;
        if(N >= 2) {
            dp[2] = 3;
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 2] * 3;
                if (i >= 4) {
                    for (int j = i - 4; j >= 0; j -= 2) {
                        dp[i] += dp[j] * 2;
                    }
                }
            }
        }

        System.out.println(dp[N]);
    }
}
