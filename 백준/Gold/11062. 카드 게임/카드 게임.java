import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K, T;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            int[] nums = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            // 구간 DP + 게임이론
            int[][] dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                if ((N - 1) % 2 == 0) {
                    dp[i][i] = nums[i];
                }
            }

            for (int len = 2; len <= N; len++) {
                for (int i = 0; i < N; i++) {
                    int j = i + len -1;
                    if(j >= N){
                        continue;
                    }

                    boolean turn = (N - len) % 2 == 0 ? true : false;
                    if (turn) {
                        dp[i][j] = Math.max(nums[i] + dp[i + 1][j], nums[j] + dp[i][j - 1]);
                    }else{
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

            System.out.println(dp[0][N-1]);
        }
    }

}