import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            T--;

            int k = Integer.valueOf(br.readLine());
            int n = Integer.valueOf(br.readLine());

            // 0호 초기화
            int[][] dp = new int[k + 1][n + 1];
            for(int i = 1 ; i < n + 1 ; i++){
                dp[0][i] = i;
            }

            for(int i = 1 ; i < k + 1 ; i++){
                for(int j = 1 ; j < n + 1 ; j++){
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }

            System.out.println(dp[k][n]);
        }
    }
}
