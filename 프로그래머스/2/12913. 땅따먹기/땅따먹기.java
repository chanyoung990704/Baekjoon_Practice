import java.util.*;

class Solution {
    int[][] dp;
    
    int solution(int[][] land) {
        int n = land.length;
        dp = new int[n][4];
        
        // dp 초기화
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int ret = 0;
        for(int i = 0; i < 4; i++)
            ret = Math.max(ret, getMaxVal(0, i, land));
        
        return ret;
    }
    
    int getMaxVal(int y, int x, int[][] land) {
        // basecase
        if(y == land.length - 1) {
            return land[y][x];
        }
        
        //dp
        if(dp[y][x] != -1) {
            return dp[y][x];
        }
        
        int ret = -1;
        // 자신의 열을 제외하고 내려오기
        for(int i = 0; i < 4; i++) {
            if(i != x) {
                ret = Math.max(ret, getMaxVal(y + 1, i, land));
            }
        }
        dp[y][x] = ret + land[y][x];
        // 자기 자신 + 최댓값 리턴
        return dp[y][x];
    }
}