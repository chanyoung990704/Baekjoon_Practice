import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] dist = new int[n + 1][n + 1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        
        // 간선 입력
        for(int[] result : results){
            dist[result[0]][result[1]] = 1;
        }
        
        // 플루이드 워셜
        for(int i = 1 ; i <= n ; i++){
            for(int a = 1 ; a <= n ; a++){
                for(int b = 1 ; b <= n ; b++){
                    if(dist[a][i] != Integer.MAX_VALUE &&
                      dist[i][b] != Integer.MAX_VALUE){
                        dist[a][b] = Math.min(dist[a][b], dist[a][i] + 
                                             dist[i][b]);
                    }
                    
                }
            }
        }
        
        for(int i = 1 ; i <= n ; i++){
            int count = 0;
            for(int j = 1 ; j <= n ; j++){
                if(i != j && (dist[i][j] != Integer.MAX_VALUE || 
                             dist[j][i] != Integer.MAX_VALUE)){
                    count++;
                }
            }
            if(count == n - 1)
                answer++;
        }
                   
        
        
        return answer;
    }
}