class Solution {
    public int solution(int n) { 
        
        int[] dp = new int[11];
        dp[0] = 0;  dp[1] = 1;
        for(int i = 2; i <= 10 ; i++)
            dp[i] = dp[i - 1] * i;
        
        int idx = 10;
        
        while(dp[idx] > n) {
            idx--;
        }
        
        return idx;
        
    }
}