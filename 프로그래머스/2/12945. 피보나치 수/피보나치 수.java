class Solution {
    public int solution(int n) {
        
        int[] fibo_dp = new int[100000 + 1];
        fibo_dp[0] = 0; fibo_dp[1] = 1;
        
        for(int i = 2 ; i <= n ; i++) {
            fibo_dp[i] = (fibo_dp[i - 1] + fibo_dp[i - 2]) % 1234567;
        }
        
        
        return fibo_dp[n];
    }
}