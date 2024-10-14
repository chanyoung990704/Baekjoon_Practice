import java.util.*;
import java.util.stream.*;

class Solution {
    int MOD = 20170805;
    int m, n;
    int[][] cityMap;
    int[][][] dp;
    public int solution(int m, int n, int[][] cityMap) {
        this.m = m;
        this.n = n;
        this.cityMap = cityMap;
        this.dp = new int[m][n][2];
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++)
                Arrays.fill(dp[i][j], -1);
        
        int answer = travel(0,0,0);
        return answer;
    }
    
    int travel(int y, int x, int dir){
        if(y == m - 1 && x == n - 1){
            return 1;
        }
        
        if(dp[y][x][dir] != -1) return dp[y][x][dir];
        
        int ret = 0;
        
        int[] dy = new int[]{0,1};
        int[] dx = new int[]{1,0};
        
        // i : 0 오른쪽, i : 1 아래쪽
        for(int i = 0 ; i < 2 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(isBoundary(ny, nx)) {
                
                if(y == 0 && x == 0){
                    ret = (ret + travel(ny, nx, i)) % MOD;
                    continue;
                }
                
                if(cityMap[ny][nx] == 1){
                    continue;
                }
                
                if(cityMap[y][x] == 2 && dir == i){
                    ret = (ret + travel(ny, nx, i)) % MOD;
                    continue;
                }
                
                if(cityMap[y][x] == 0){
                    ret = (ret + travel(ny, nx, i)) % MOD;
                    continue;
                }
                
            }
        }
        
        dp[y][x][dir] = ret;
        return dp[y][x][dir];
    }
    
    boolean isBoundary(int y, int x){
        return y >= 0 && y < m && x >= 0 && x < n;
    }
    
}