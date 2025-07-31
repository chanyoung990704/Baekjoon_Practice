import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        
        int[][] dp = new int[info.length + 1][m + 1];
        
        for(int i = 1; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                // 이전 무게 갱신
                dp[i][j] = dp[i-1][j];
                
                // 추가 삽입 가능하면
                if(info[i-1][1] <= j){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - info[i-1][1]] + info[i-1][0]);
                }
            }
        }
        
        int sum = 0;
        for(int i = 0 ; i < info.length ; i++){
            sum += info[i][0];
        }
        
        System.out.println(Arrays.deepToString(dp));
        
        if(sum - dp[info.length][m-1] >= n){
            return -1;
        }
        
        return sum - dp[info.length][m-1];
    }
}