

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

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // dp[i] = i번째 돌까지 도달 가능한지 여부
        boolean[] dp = new boolean[N];
        dp[0] = true; // 첫 번째 돌에서 시작

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]) {
                    // j에서 i로 이동할 때 필요한 힘 계산
                    int power = (i - j) * (1 + Math.abs(nums[j] - nums[i]));
                    if (power <= K) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(dp[N-1] ? "YES" : "NO");
    }
}
