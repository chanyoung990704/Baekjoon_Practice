import java.util.*;

class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    boolean[] visited;
    int[][] cnt;
    public int solution(int n, int[][] lighthouse) {
        cnt = new int[n + 1][2];
        visited = new boolean[n + 1];

        for(int i = 0 ; i < n + 1 ; i++) adj.add(new ArrayList<>());
        
        for(int[] light : lighthouse){
            adj.get(light[0]).add(light[1]);
            adj.get(light[1]).add(light[0]);
        }
        
        dfs(1);
        
        return Math.min(cnt[1][0], cnt[1][1]);
    }
    
    void dfs(int cur) {
        
        visited[cur] = true;
        cnt[cur][0] = 0;
        cnt[cur][1] = 1;
        
        for(int child : adj.get(cur)){
            if(!visited[child]){
                dfs(child);
                cnt[cur][0] += cnt[child][1];
                cnt[cur][1] += Math.min(cnt[child][0], cnt[child][1]);
            }
        }
    }
    
}