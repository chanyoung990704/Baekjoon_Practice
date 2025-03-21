import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        // dp
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        int mod = 1000000007;
        
        for(int m : money){
            for(int i = m ; i <= n ; i++){
                dp[i] = (dp[i] % mod + dp[i - m] % mod) % mod;
            }
        }
        
        return dp[n];
    }
}