import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        // 간선 저장
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < computers.length ; i++){
            for(int j = 0 ; j < computers[i].length ; j++){
                // 저장
                if(computers[i][j] == 1){
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        
        // dfs 진행
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                answer++;
                dfs(graph, visited, i);
            }
        }
        
        return answer;
    }
    
    void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int cur){
        visited[cur] = true;
        
        for(int next : graph.get(cur)){
            if(!visited[next]){
                dfs(graph, visited, next);
            }
        }
    }
}