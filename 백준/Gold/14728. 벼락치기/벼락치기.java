import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, T;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[] dp = new int[T + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());

            for (int j = T; j - k >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - k] + s);
            }
        }

        System.out.println(dp[T]);

    }

}