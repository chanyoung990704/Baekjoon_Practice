import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int max_a = Arrays.stream(problems).mapToInt(i -> i[0]).max().orElse(0);
        int max_c = Arrays.stream(problems).mapToInt(i -> i[1]).max().orElse(0);
        
        alp = Math.min(alp, max_a);
        cop = Math.min(cop, max_c);
                
        int[][] dp = new int[max_a + 1][max_c + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        
        dp[alp][cop] = 0;
        
        for(int i = alp ; i <= max_a ; i++){
            for(int j = cop ; j <= max_c ; j++){
                
                if(j < max_c) dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                if(i < max_a) dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                
                for(int[] p : problems){
                    if(p[0] <= i && p[1] <= j){
                        int na = Math.min(max_a, i + p[2]);
                        int nc = Math.min(max_c, j + p[3]);
                        dp[na][nc] = Math.min(dp[na][nc], dp[i][j] + p[4]);
                    }
                }
                
            }
        }
        
        
        return dp[max_a][max_c];
    }
}