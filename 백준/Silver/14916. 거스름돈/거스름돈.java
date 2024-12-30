import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        int[] dp = new int[100000 + 1];
        Arrays.fill(dp, 1000000000);
        dp[0] = 0;

        for(int i = 1 ; i <= n ; i++){
            if(i >= 2) dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            if(i >= 5) dp[i] = Math.min(dp[i], dp[i - 5] + 1);
        }

        if (dp[n] == 1000000000) {
            dp[n] = -1;
        }


        System.out.println(dp[n]);

        br.close();


    }
}