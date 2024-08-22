import java.util.*;

class Solution {
    int[][] arr;
    int[][] dist;
    int n;
    int m;
    public int solution(int m, int n, int[][] puddles) {
        this.n = n;
        this.m = m;
        arr = new int[n][m];
        dist = new int[n][m];
        
        for(int[] puddle : puddles) arr[puddle[1] - 1][puddle[0] - 1] = 1;
        for(int i = 0 ; i < n ; i++) Arrays.fill(dist[i], -1);
        
        return solve(0, 0);
    }
    
    int solve(int y, int x){
        if(y >= n || x >= m || arr[y][x] == 1) return 0; // 범위를 벗어나거나 웅덩이인 경우
        if(y == n - 1 && x == m - 1) return 1; // 목적지에 도달한 경우
        if(dist[y][x] != -1) return dist[y][x];
        
        dist[y][x] = (solve(y + 1, x) + solve(y, x + 1)) % 1000000007;
        return dist[y][x];
    }
}