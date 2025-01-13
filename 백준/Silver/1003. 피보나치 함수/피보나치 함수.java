import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    static int[] zeroCnt = new int[41];
    static int[] oneCnt = new int[41];
    static int[] dp = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            int cur = Integer.valueOf(br.readLine());
            Arrays.fill(dp, -1);
            Arrays.fill(zeroCnt, 0);
            Arrays.fill(oneCnt, 0);

            fibonacci(cur);

            System.out.println(zeroCnt[cur] + " " + oneCnt[cur]);

        }
    }

    static int fibonacci(int n){
        if(n == 0){
            zeroCnt[0] = 1;
            oneCnt[0] = 0;
            dp[0] = 0;
            return 0;
        }else if(n == 1){
            oneCnt[1] = 1;
            zeroCnt[1] = 0;
            dp[1] = 1;
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int ret = fibonacci(n - 1) + fibonacci(n - 2);

        dp[n] = ret;
        zeroCnt[n] = zeroCnt[n - 1] + zeroCnt[n - 2];
        oneCnt[n] = oneCnt[n - 1] + oneCnt[n - 2];

        return dp[n];
    }
}
