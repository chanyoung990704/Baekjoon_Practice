import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        double[][] dist = new double[N][N];

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1 ; j < N; j++) {
                int x = Math.abs(list.get(i)[0] - list.get(j)[0]);
                int y = Math.abs(list.get(i)[1] - list.get(j)[1]);

                double d = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

                dist[i][j] = d;
                dist[j][i] = d;
            }
        }

        int start = 0;
        double[][] memo = setup(dist, N, start);

        solve(start, N, memo, dist);

        double res = Double.MAX_VALUE;
        int fullRoute = (1 << N) - 1;

        for(int i = 0; i < N; i++) {
            if(i == start){
                continue;
            }
            double curDist = memo[i][fullRoute] + dist[i][start];
            res = Math.min(res, curDist);
        }

        System.out.println(res);
    }

    private static void solve(int start, int n, double[][] memo, double[][] dist) {
        for (int r = 3; r <= n; r++) {
            List<Integer> combs = new  ArrayList<>();
            getComb(n, r, 0, 0, combs);

            for (int subSet : combs) {
                if (notIn(subSet, start)) {
                    continue;
                }

                for(int next = 0 ; next < n; next++) {
                    if(start == next || notIn(subSet, next)) {
                        continue;
                    }

                    int noNextRoute = (1 << next) ^ subSet;
                    double min = Double.MAX_VALUE;

                    for (int e = 0; e < n; e++) {
                        if(start == e || next == e || notIn(subSet, e)) {
                            continue;
                        }

                        if(dist[e][next] == 0 || memo[e][noNextRoute] == Double.MAX_VALUE) {
                            continue;
                        }

                        double nextDist = memo[e][noNextRoute] + dist[e][next];
                        min = Math.min(min, nextDist);
                    }

                    memo[next][subSet] = min;
                }
            }
        }
    }

    private static boolean notIn(int subSet, int start) {
        return ((1 << start) & subSet) == 0;
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

    private static double[][] setup(double[][] dist, int n, int start) {
        double[][] memo = new double[n][1 << n];
        for(double[] m : memo) {
            Arrays.fill(m, Double.MAX_VALUE);
        }

        for(int e  = 0 ; e < n; e++) {
            if (start == e || dist[start][e] == 0) {
                continue;
            }
            memo[e][(1 << start) | (1 << e)] = dist[start][e];
        }

        return memo;
    }
}
