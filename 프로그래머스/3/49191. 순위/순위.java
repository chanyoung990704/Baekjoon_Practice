import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        // 플루이드 워셜
        int[][] dist = new int[n+1][n+1];
        for(int i = 0 ; i < n + 1 ; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        
        for(int i = 0 ; i < results.length ; i++){
            int f = results[i][0];
            int t = results[i][1];
            
            dist[f][t] = 1;
        }
        
        for(int i = 1 ; i < n + 1 ; i++){
            for(int a = 1 ; a < n + 1 ; a++){
                for(int b = 1 ; b < n + 1; b++){
                    // 경로가 존재해야 함
                    if(dist[a][i] != Integer.MAX_VALUE && dist[i][b] != Integer.MAX_VALUE){
                        dist[a][b] = Math.min(dist[a][b], dist[a][i] + dist[i][b]);
                    }
                }
            }
        }
    
        int answer = 0;
        
        for(int i = 1 ; i < n + 1 ; i++){
            int cnt = 0;
            for(int j = 1 ; j < n + 1 ; j++){
                if(dist[i][j] != Integer.MAX_VALUE || dist[j][i] != Integer.MAX_VALUE){
                    cnt++;
                }
            }
            if(cnt == n){
                answer++;
            }
        }
        
        return answer;
    }
}