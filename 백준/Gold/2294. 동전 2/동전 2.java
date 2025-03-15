

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        nums = nums.stream().distinct().sorted().collect(Collectors.toList());

        int[][] dp = new int[nums.size() + 1][k + 1];

        // 초기화: 0원을 만드는 경우는 0개의 동전 필요
        for (int i = 0; i <= nums.size(); i++) {
            dp[i][0] = 0;
        }

        // 나머지 금액은 불가능한 값으로 초기화
        for (int i = 0; i <= nums.size(); i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE - 1; // overflow 방지
            }
        }

        for(int i = 1 ; i <= nums.size() ; i++) {
            int cur = nums.get(i - 1);
            // 동전을 사용할 수 있으면
            for (int j = 1; j <= k; j++) {
                // 현재 동전 사용안하는 경우
                dp[i][j] = dp[i - 1][j];

                // 현재 동전 사용하는 경우
                if(j >= cur && dp[i][j - cur] != Integer.MAX_VALUE - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - cur] + 1);
                }
            }
        }

        System.out.println(dp[nums.size()][k] == Integer.MAX_VALUE - 1 ? -1 : dp[nums.size()][k]);
    }
}
