import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   


        int N = Integer.valueOf(br.readLine());

        int[][] dp = new int[N+1][N+1];
        for(int i = 0 ; i < N + 1 ; i++){
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 1;

        if(N == 1){
            System.out.println(1);
            return;
        }

        System.out.println(zigzag(N, N, dp) * 2 % 1000000);
    }

    static int zigzag(int n, int k, int[][] dp){
        // 기저 조건
        if(k == 0){
            if(n == 0) return 1;
            else return 0;
        }

        int ret = dp[n][k];
        if(ret != -1){
            return ret;
        }

        dp[n][k] = (zigzag(n, k - 1, dp) + zigzag(n - 1, n - k, dp)) % 1000000;
        return dp[n][k];
        
    }
}


