import java.util.Arrays;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int max_alp = Arrays.stream(problems).mapToInt(i -> i[0]).max().orElse(0);
        int max_cop = Arrays.stream(problems).mapToInt(i -> i[1]).max().orElse(0);
        
        alp = Math.min(alp, max_alp);
        cop = Math.min(cop, max_cop);
        
        int[][] dp = new int[max_alp + 1][max_cop + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        
        dp[alp][cop] = 0;
        
        for (int i = alp; i <= max_alp; i++) {
            for (int j = cop; j <= max_cop; j++) {
                if (i < max_alp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                if (j < max_cop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                for (int[] problem : problems) {
                    if (i >= problem[0] && j >= problem[1]) {
                        int next_alp = Math.min(max_alp, i + problem[2]);
                        int next_cop = Math.min(max_cop, j + problem[3]);
                        dp[next_alp][next_cop] = Math.min(dp[next_alp][next_cop], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        
        return dp[max_alp][max_cop];
    }
}