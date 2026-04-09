import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        /////////////DP계산//////////////////

        boolean[][] dp = new boolean[N][N];

        // 길이 1
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        // 길이 2
        for (int i = 0; i < N - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= N; len++) {
            for (int i = 0; i < N - len + 1; i++) {
                int j = i + len -1;
                if (nums[i] == nums[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
            }
        }


        //////////////////////////////////////

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;

            sb.append(dp[s][e] ? '1' : '0').append("\n");

        }

        System.out.println(sb);

    }

}
