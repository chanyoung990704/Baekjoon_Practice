import java.util.*;

class Solution {
    int n, infection, k;
    int[][] edges;
    int answer = 0;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n; this.infection = infection; this.k = k; this.edges = edges;
        
        dfs(0, new int[k]);
        return answer;
    }
    
    void dfs(int idx, int[] selected){
        if(idx == k){
            answer = Math.max(answer, bfs(selected));
            return;
        }
        for(int i = 1; i <= 3; i++){
            selected[idx] = i;
            dfs(idx+1, selected);
        }
    }
    
    int bfs(int[] selected){
        boolean[] visited = new boolean[n + 1];
        visited[infection] = true;
        
        List<Integer> infected = new ArrayList<>();
        infected.add(infection);
        
        for(int s = 0; s < k; s++){
            int type = selected[s];
            List<Integer> newlyInfected = new ArrayList<>();
            
            Queue<Integer> q = new ArrayDeque<>(infected);
            while(!q.isEmpty()){
                int node = q.poll();
                for(int[] e : edges){
                    if((e[0] == node || e[1] == node) && e[2] == type){
                        int next = e[0] == node ? e[1] : e[0];
                        if(!visited[next]){
                            visited[next] = true;
                            newlyInfected.add(next);
                            q.add(next);
                        }
                    }
                }
            }
            infected.addAll(newlyInfected);
        }
        
        return infected.size();
    }
}