

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0];
        int K = NK[1];

        // 물건
        int[][] stuff = new int[N + 1][2];
        for(int i = 1; i < N + 1; i++) {
            stuff[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // DP
        int[][] dp = new int[N + 1][K + 1];
        for(int i = 1; i < N + 1; i++) {
            // 현재 물건의 무게
            int stuffWeight = stuff[i][0];
            int stuffValue = stuff[i][1];
            for(int j = 1; j < K + 1; j++) {
                // 가방에 못 담는 경우
                if (stuffWeight > j) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stuffWeight] + stuffValue);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
