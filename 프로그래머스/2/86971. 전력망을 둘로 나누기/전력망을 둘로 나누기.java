import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < wires.length ; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        
        // 하나씩 끊어 보기
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            
            map.get(a).remove((Integer) b);
            map.get(b).remove((Integer) a);
            
            int aCnt = dfs(map, a, new boolean[n + 1]);
            int bCnt = n - aCnt;
            
            min = Math.min(min, Math.abs(aCnt - bCnt));
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        return min;
    }
    
    int dfs(Map<Integer, List<Integer>> map, int cur, boolean[] visited){
        
        int cnt = 1;
        visited[cur] = true;
        
        for(int next : map.get(cur)){
            if(!visited[next]){
                cnt += dfs(map, next, visited);
            }
        }
        
        return cnt;
    }
}