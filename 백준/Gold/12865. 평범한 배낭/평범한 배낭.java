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

        int[][] items = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K + 1];


        for (int item = 1; item <= N; item++) {
            int W = items[item-1][0];
            int V = items[item-1][1];

            for (int weight = 0; weight <= K; weight++) {
                dp[item][weight] = dp[item-1][weight];
                if (weight >= W) {
                    dp[item][weight] = Math.max(dp[item][weight], dp[item - 1][weight - W] + V);
                }
            }
        }

        System.out.println(dp[N][K]);
    }

}