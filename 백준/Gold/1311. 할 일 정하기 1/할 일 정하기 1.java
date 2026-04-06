import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] cost;
    static int[][] memo;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // memo[사람 인덱스][현재까지의 일 배정 상태]
        memo = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], -1);
        }

        // 0번 사람부터, 아무 일도 배정되지 않은 상태(0)로 시작
        System.out.println(solve(0, 0));
    }

    static int solve(int pIdx, int mask) {
        // 모든 사람에게 일이 배정된 경우 (기저 조건)
        if (pIdx == N) {
            return 0;
        }

        // 이미 계산된 값이 있는 경우 반환 (메모이제이션)
        if (memo[pIdx][mask] != -1) {
            return memo[pIdx][mask];
        }

        int res = INF;
        // 현재 사람(pIdx)에게 할당할 수 있는 일(j)을 순회
        for (int j = 0; j < N; j++) {
            // j번째 일이 아직 배정되지 않았다면
            if ((mask & (1 << j)) == 0) {
                // 다음 사람으로 넘어가며 비용 합산 및 최솟값 갱신
                res = Math.min(res, solve(pIdx + 1, mask | (1 << j)) + cost[pIdx][j]);
            }
        }

        return memo[pIdx][mask] = res;
    }
}