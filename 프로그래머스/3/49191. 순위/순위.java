import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] dist = new int[n + 1][n + 1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        
        for(int[] res : results) dist[res[0]][res[1]] = 1;
        
        for(int i = 1 ; i <= n ; i++){
            for(int a = 1 ; a <= n ; a++){
                for(int b = 1 ; b <= n ; b++){
                    if(dist[a][i] != Integer.MAX_VALUE &&
                      dist[i][b] != Integer.MAX_VALUE) {
                        dist[a][b] = Math.min(dist[a][b], dist[a][i] +
                                             dist[i][b]);
                    }
                }
            }
        }
        
        
        for(int a = 1 ; a <= n ; a++){
            int cnt = 0;
            for(int b = 1 ; b <= n ; b++){
                if(dist[a][b] != Integer.MAX_VALUE || 
                  dist[b][a] != Integer.MAX_VALUE) cnt++;
            }
            if(cnt == n) answer++;
        }
        
        
        return answer;
    }
}