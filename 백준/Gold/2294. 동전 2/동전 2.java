import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 1; j <= K; j++) {
                if (j - n < 0) {
                    continue;
                }
                if (dp[j - n] != 1e9) {
                    dp[j] = Math.min(dp[j], dp[j - n] + 1);
                }
            }
        }

        System.out.println(dp[K] == 1e9 ? -1 : dp[K]);

    }

}