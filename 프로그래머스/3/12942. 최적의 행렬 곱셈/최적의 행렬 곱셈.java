import java.util.*;

class Solution {
    int[][] dp;
    int len;
    public int solution(int[][] matrix_sizes) {
        
        len = matrix_sizes.length;
        dp = new int[len][len];
        for(int i = 0 ; i < len ; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        
        for(int size = 2 ; size <= len ; size++){
            for(int lo = 0 ; lo < len - size + 1 ; lo++){
                int hi = lo + size - 1;
                for(int i = lo ; i < hi ; i++){
                    int val = dp[lo][i] + dp[i + 1][hi] + matrix_sizes[lo][0] * matrix_sizes[i][1] * matrix_sizes[hi][1];
                    dp[lo][hi] = Math.min(dp[lo][hi], val);
                }
            }
        }
        
        return dp[0][len - 1];
    }
}