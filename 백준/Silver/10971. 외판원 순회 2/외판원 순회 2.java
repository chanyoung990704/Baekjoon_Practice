import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            dist[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int S = 0;
        int[][] memo = setup(S, N, dist);

        solve(memo, dist, S, N);

        int res = Integer.MAX_VALUE;
        int endRoute = (1 << N) - 1;

        for(int i = 0 ; i < N ; i++){
            if(i == S || dist[i][S] == 0 || memo[i][endRoute] == Integer.MAX_VALUE){
                continue;
            }

            res = Math.min(res, memo[i][endRoute] + dist[i][S]);
        }

        System.out.println(res);
    }

    private static void solve(int[][] memo, int[][] dist, int s, int n) {
        for (int r = 3; r <= n; r++) {
            List<Integer> combs = new ArrayList<>();
            getComb(n, r, 0, 0, combs);

            for(int comb : combs) {
                if (notIn(comb, s)) {
                    continue;
                }

                // next찾기
                for (int next = 0; next < n; next++) {
                    if(next == s || notIn(comb, next)) {
                        continue;
                    }

                    int notIncludeNext = (1 << next) ^ comb;

                    int min = Integer.MAX_VALUE;
                    for (int e = 0; e < n; e++) {
                        if(s == e || next == e || notIn(comb, e)) {
                            continue;
                        }

                        if(memo[e][notIncludeNext] == Integer.MAX_VALUE || dist[e][next] == 0) {
                            continue;
                        }

                        int nextDist = memo[e][notIncludeNext] + dist[e][next];
                        min = Math.min(min, nextDist);
                    }

                    memo[next][comb] = min;
                }
            }
        }
    }

    private static boolean notIn(int comb, int s) {
        return ((1 << s) & comb) == 0;
    }

    private static void getComb(int n, int r, int idx, int b, List<Integer> combs) {
        int remain = n - idx;
        if (remain < r) {
            return;
        }

        if (r == 0) {
            combs.add(b);
            return;
        }

        for (int i = idx; i < n; i++) {
            int next = b | (1 << i);
            getComb(n, r - 1, i + 1, next, combs);
        }

    }

    private static int[][] setup(int s, int n, int[][] dist) {
        int[][] memo = new int[n][1 << n];

        for(int[] m : memo) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }

        for (int e = 0; e < n; e++) {
            if (s == e || dist[s][e] == 0) {
                continue;
            }
            memo[e][(1 << s) | (1 << e)] = dist[s][e];
        }

        return memo;
    }
}
