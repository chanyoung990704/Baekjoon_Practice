import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            dist[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int min = INF;
        for (int s = 0; s < N; s++) {
            int[][] memo = setup(s, N, dist);
            solve(s, N, dist, memo);
            int curStartCost = findMinCost(memo, dist, s, N);
            if (curStartCost < min) {
                min = curStartCost;
            }
        }

        System.out.println(min);
    }

    static int findMinCost(int[][] memo, int[][] dist, int S, int N) {
        int endState = (1 << N) - 1;
        int min = INF;

        for (int e = 0; e < N; e++) {
            if (e == S) continue;
            if (dist[e][S] == 0) continue; // 돌아가는 길 없음

            int tourCost = memo[e][endState] + dist[e][S];
            if (tourCost < min) {
                min = tourCost;
            }
        }

        return min;
    }

    static int[][] setup(int S, int N, int[][] dist) {
        int[][] memo = new int[N][1 << N];
        for (int[] row : memo) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i < N; i++) {
            if (i == S) continue;
            if (dist[S][i] == 0) continue; // 시작 도시에서 바로 못 가는 경우
            memo[i][(1 << S) | (1 << i)] = dist[S][i];
        }
        return memo;
    }

    static void solve(int S, int N, int[][] dist, int[][] memo) {
        for (int R = 3; R <= N; R++) {
            List<Integer> combinations = new ArrayList<>();
            getCombination(N, R, 0, combinations, 0);

            for (int subset : combinations) {
                if (notIn(S, subset)) continue;

                for (int next = 0; next < N; next++) {
                    if (next == S || notIn(next, subset)) continue;

                    int exceptNext = subset ^ (1 << next);
                    int min = INF;

                    for (int e = 0; e < N; e++) {
                        if (S == e || next == e || notIn(e, subset)) continue;
                        if (dist[e][next] == 0) continue; // 길 없음
                        if (memo[e][exceptNext] == INF) continue;

                        int newDist = memo[e][exceptNext] + dist[e][next];
                        if (newDist < min) {
                            min = newDist;
                        }
                    }

                    memo[next][subset] = min;
                }
            }
        }
    }

    private static boolean notIn(int s, int subset) {
        return ((1 << s) & subset) == 0;
    }

    private static void getCombination(int n, int r, int idx, List<Integer> combinations, int bit) {
        int remain = n - idx;
        if (remain < r) return;

        if (r == 0) {
            combinations.add(bit);
            return;
        }

        for (int i = idx; i < n; i++) {
            int next = (1 << i) | bit;
            getCombination(n, r - 1, i + 1, combinations, next);
        }
    }
}
