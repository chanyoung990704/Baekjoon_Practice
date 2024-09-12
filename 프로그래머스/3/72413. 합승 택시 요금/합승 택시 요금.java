import java.util.*;

class Solution {
    int n, s, a, b;
    int[][] fares;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        this.s = s;
        this.a = a;
        this.b = b;
        this.fares = fares;
        
        int[][] dist = getDist(); // 플로이드 워셜
        
        int minVal = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            minVal = Math.min(minVal, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        
        return minVal;
    }
    
    int[][] getDist() {
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        
        for (int[] fare : fares) {
            dist[fare[0]][fare[1]] = fare[2];
            dist[fare[1]][fare[0]] = fare[2];
        }
       
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        return dist;
    }
}