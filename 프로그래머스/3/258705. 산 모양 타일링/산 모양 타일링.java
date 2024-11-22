import java.util.*;
class Solution {
    final int MOD = 10007;
    public int solution(int n, int[] tops) {
        long[] dp = new long[n];
        long[] colors = new long[n];
        
        // Initialize dp and colors array with MOD
        Arrays.fill(dp, 0 % MOD);
        Arrays.fill(colors, 0 % MOD);
        
        // 초기 확인
        if(tops[0] == 0) {
            dp[0] = 3 % MOD;
            colors[0] = 1 % MOD;
        } else {
            dp[0] = 4 % MOD;
            colors[0] = 1 % MOD; 
        }
        
        // 순회
        for(int i = 1; i < n; i++) {
            int prev = tops[i - 1];
            int cur = tops[i];
            long cnt = (dp[i - 1] - colors[i - 1] + MOD) % MOD;
            
            if(prev == 0 && cur == 1) {
                dp[i] = ((cnt * 4) % MOD + (colors[i - 1] * 3) % MOD) % MOD;
                colors[i] = dp[i - 1] % MOD;
            } else if(prev == 0 && cur == 0) {
                dp[i] = ((cnt * 3) % MOD + (colors[i - 1] * 2) % MOD) % MOD;
                colors[i] = dp[i - 1] % MOD;
            } else if(prev == 1 && cur == 0) {
                dp[i] = ((cnt * 3) % MOD + (colors[i - 1] * 2) % MOD) % MOD;
                colors[i] = dp[i - 1] % MOD;
            } else if(prev == 1 && cur == 1) {
                dp[i] = ((cnt * 4) % MOD + (colors[i - 1] * 3) % MOD) % MOD;
                colors[i] = dp[i - 1] % MOD;
            }
        }
    
        return (int)(dp[n - 1] % MOD);
    }
}