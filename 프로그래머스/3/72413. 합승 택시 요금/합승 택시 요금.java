import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        // 플루이드 워셜
        int[][] dist = new int[n+1][n+1];
        for(int i = 0 ; i < n + 1 ; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        
        for(int[] f : fares){
            dist[f[0]][f[1]] = f[2];
            dist[f[1]][f[0]] = f[2];
        }
        
        for(int i = 1 ; i < n + 1 ; i++){
            for(int f = 1 ; f < n + 1 ; f++){
                for(int t = 1 ; t < n + 1 ; t++){
                    if(dist[f][i] != Integer.MAX_VALUE && dist[i][t] != Integer.MAX_VALUE){
                        dist[f][t] = Math.min(dist[f][t], dist[f][i] + dist[i][t]);
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1 ; i < n + 1 ; i++){
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return answer;
    }
}