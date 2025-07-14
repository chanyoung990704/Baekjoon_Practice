import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            nums.add(sc.nextInt());
        }

        // dp
        boolean[][] dp = new boolean[N][N];

        // 길이 1
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        // 길이 2
        for(int i = 0 ; i < N - 1; i++) {
            int j = i + 1;
            if(nums.get(i).equals(nums.get(j))) {
                dp[i][j] = true;
            }
        }

        // 길이 3 이상
        for(int len = 3  ; len <= N; len++) {
            for(int i = 0 ; i < N - len + 1; i++) {
                int j = i + len - 1;
                if(nums.get(i).equals(nums.get(j)) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            sb.append(dp[s - 1][e - 1] ? 1 : 0).append("\n");
        }

        System.out.print(sb.toString());
    }
}
