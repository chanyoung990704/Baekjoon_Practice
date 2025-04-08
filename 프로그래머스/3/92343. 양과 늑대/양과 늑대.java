import java.util.*;
import java.util.stream.*;

class Solution {
    int[] info;
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        
        // 그래프
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            int p = edge[0];
            int c = edge[1];
            graph.computeIfAbsent(p, k -> new ArrayList<>()).add(c);
        }
        
        Set<Integer> nexts = new HashSet<>();
        nexts.add(0);
        dfs(graph, 0, 0, 0, nexts);
            
        return answer;
    }
    
    void dfs(Map<Integer, List<Integer>> graph, int cur, int sheep, int wolf, Set<Integer> nexts){
                
        if(info[cur] == 0){
            sheep++;
        }else{
            wolf++;
        }
        
        // 양의 숫자와 늑대의 숫자
        if(sheep <= wolf){
            return;
        }
        
        answer = Math.max(answer, sheep);
        
        // 다음 경로 업데이트
        Set<Integer> updated = new HashSet<>(nexts);
        updated.remove(cur);
        if(graph.containsKey(cur)){
            for(int n : graph.get(cur)){
                updated.add(n);
            }
        }
        
        // 진행
        for(int next : updated){
            dfs(graph, next, sheep, wolf, updated);
        }
        
    }
    
}