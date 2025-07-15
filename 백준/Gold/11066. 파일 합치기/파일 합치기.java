import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

            int[][] dp = new int[N][N];

            List<Integer> prefix = new ArrayList<>();
            prefix.add(0);
            for (int n : arr) {
                prefix.add(prefix.get(prefix.size() - 1) + n);
            }


            for (int len = 2; len <= N; len++) {
                for (int i = 0; i <= N - len; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + prefix.get(j + 1) - prefix.get(i));
                    }
                }


            }

            sb.append(dp[0][N - 1]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
