import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 무게 분할
            for(int j = 1 ; k > 0 ; j = j << 1){
                int cnt = Math.min(k, j);
                int V = v * cnt, C = c * cnt, K = cnt;
                // dp 계산
                for (int w = M; w >= 0; w--) {
                    if (w - V < 0) {
                        continue;
                    }
                    dp[w] = Math.max(dp[w], dp[w - V] + C);
                }

                k -= cnt;
            }
        }

        System.out.println(dp[M]);


    }

}