import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            //누적합
            int[] sums = new int[N+1];
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }

            // 구간 DP
            int[][] dp = new int[N][N];
            

            // 길이 2
            for (int len = 2; len <= N; len++) {
                for (int i = 0; i < N; i++) {
                    int j = i + len - 1;
                    if (j >= N) {
                        break;
                    }

                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int val = dp[i][k] + dp[k + 1][j] + (sums[j + 1] - sums[i]);
                        dp[i][j] = Math.min(dp[i][j], val);
                    }
                }
            }

            // 출력
            sb.append(dp[0][N - 1]).append("\n");

        }

        System.out.println(sb);

    }

}
