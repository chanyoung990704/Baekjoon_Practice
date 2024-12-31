import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int[] dp = new int[5001];
        int max = 1000000000;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i = 1 ; i <= N ; i++){
            if(i >= 3) dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            if(i >= 5) dp[i] = Math.min(dp[i], dp[i - 5] + 1);
        }

        if(dp[N] == max) System.out.println(-1);
        else System.out.println(dp[N]);

        br.close();


    }
}