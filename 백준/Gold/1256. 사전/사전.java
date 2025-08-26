import java.io.*;
import java.util.*;

public class Main {
    static int[][] bino;
    static final int CAP = 1_000_000_001; // 10^9 + 1로 안전 캡핑

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NMK = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NMK[0];
        int M = NMK[1];
        int K = NMK[2];

        // 파스칼 삼각형으로 C(n, r) 계산, CAP로 상한
        bino = new int[N + M + 1][N + M + 1];
        for (int i = 0; i <= N + M; i++) {
            bino[i][0] = 1;
            bino[i][i] = 1;
            for (int j = 1; j < i; j++) {
                long sum = (long) bino[i - 1][j - 1] + bino[i - 1][j];
                bino[i][j] = (int) Math.min(CAP, sum);
            }
        }

        // 전체 경우의 수가 K보다 작으면 -1
        if (bino[N + M][N] < K) {
            System.out.println(-1);
            return;
        }

        // 기존 형태 유지: k는 0-based로 K-1
        int[] k = new int[]{K - 1};

        solve(N, M, "", k);
    }

    private static void solve(int n, int m, String s, int[] k) {
        if (k[0] < 0) {
            return;
        }

        if (n == 0 && m == 0) {
            if (k[0] == 0) {
                System.out.println(s);
            }
            k[0]--;
            return;
        }

        // 'a' 가지 처리 (원래 형태처럼 if(n > 0) solve 유지, 스킵 추가로 최적화)
        if (n > 0) {
            int left = bino[n + m - 1][n - 1];
            if (left <= k[0]) {
                k[0] -= left;
            } else {
                solve(n - 1, m, s + "a", k);
            }
        }

        // 'z' 가지 처리 (원래 형태처럼 if(m > 0) solve 유지, 스킵 추가로 최적화)
        if (m > 0) {
            int right = bino[n + m - 1][n];
            if (right <= k[0]) {
                k[0] -= right;
            } else {
                solve(n, m - 1, s + "z", k);
            }
        }
    }
}
