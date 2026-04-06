import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] dist, dp;
    static final int INF = 1000000000;

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(tsp(0, 1));

    }

    private static int tsp(int node, int visited) {
        if (visited == ((1 << N) - 1)) {
            return dist[node][0] == 0 ? INF : dist[node][0];
        }

        if (dp[node][visited] != -1) return dp[node][visited];

        int cost = INF;

        for (int i = 0; i < N; i++) {
            if ((visited >> i & 1) == 0 && dist[node][i] != 0) {
                int next = visited | (1 << i);
                int result = tsp(i, next);
                if (result != INF) {
                    cost = Math.min(cost, result + dist[node][i]);
                }
            }
        }
        return dp[node][visited] = cost;
    }
}
