import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.valueOf(br.readLine()));
        }

        coins.sort(Comparator.naturalOrder());

        // dp
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            // 현재 코인 가치
            int cur = coins.get(i-1);
            for(int j = 0 ; j <= k ; j++){
                // 현재 dp 초기화
                dp[i][j] = dp[i-1][j];
                if(j >= cur){
                    dp[i][j] += dp[i][j-cur];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
