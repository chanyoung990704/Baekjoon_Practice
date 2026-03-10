import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] dist;
    static int P;
    static int idx = 0; // 켜져있는지 꺼저있는지
    static int[] dp;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 비트마스킹으로 idx 입력받기
        String status = br.readLine();
        for (int i = 0; i < status.length(); i++) {
            char c = status.charAt(i);
            if (c == 'Y') {
                idx = idx | (1 << i);
            }
        }

        P = Integer.parseInt(br.readLine());

        // DP
        dp = new int[1 << N];
        Arrays.fill(dp, INF);

        int ret = solve(idx);
        System.out.println(ret == INF ? -1 : ret);
    }

    private static int solve(int idx) {
        // P개가 켜졌을 경우
        if (Integer.bitCount(idx) >= P) {
            return 0;
        }

        int ret = dp[idx];
        if (ret != INF) {
            return ret;
        }

        // 다음 거 탐색
        for (int i = 0; i < N; i++) {
            // 현재가 꺼져있으면 무시
            if((idx >> i & 1) != 1){
                continue;
            }

            // 다음 킬 거 탐색
            for (int j = 0; j < N; j++) {
                // 다음 것이 켜져있으면 무시
                if (i == j || (idx >> j & 1) == 1) {
                    continue;
                }
                // 킬 수 있음
                ret = Math.min(ret, solve(idx | (1 << j)) + dist[i][j]);
            }
        }

        return dp[idx] = ret;
    }

}