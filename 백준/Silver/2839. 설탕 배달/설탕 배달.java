import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int N = Integer.valueOf(br.readLine());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 100000000);
        dp[0] = 0;

        for(int i = 3; i<= N ; i++){
            if(dp[i - 3] != 100000000){
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
            if(i >= 5 && dp[i - 5] != 100000000){
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        System.out.println(dp[N] == 100000000 ? -1 : dp[N]);
    }
}

