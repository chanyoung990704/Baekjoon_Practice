import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[x] = 0;
        for(int i = x ; i <= y ; i++) {
            
            // n 더하기
            if(i - n >= 0 && dp[i - n] != Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i], dp[i - n] + 1);
            }
            
            // 2 곱하기
            if(i / 2 >= 0 && i % 2 == 0 && dp[i / 2] != Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            
            if(i / 3 >= 0 && i % 3 == 0 && dp[i / 3] != Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            
        }
        
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}