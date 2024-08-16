import java.util.*;
import java.util.stream.*;

class Solution {
    
    int[] parent;
    
    int findParent(int a){
        if(parent[a] != a) parent[a] = findParent(parent[a]);
        return parent[a];
    }
    
    void unionParent(int a, int b){
        int rootA = findParent(a);
        int rootB = findParent(b);
        
        if(rootA > rootB) parent[rootA] = rootB;
        else parent[rootB] = rootA;
    }
    
    
    public int solution(int[] cards) {
        int answer = 1;
        
        parent = new int[cards.length + 1];
        for(int i = 0 ; i <= cards.length ; i++) parent[i] = i;
        boolean[] visited = new boolean[cards.length + 1];
        
        for(int i = 0 ; i < cards.length ; i++){
            if(visited[i + 1]) continue;
            
            visited[i + 1] = true;
            int next = cards[i];
            unionParent(i + 1, next);
            while(!visited[next]){
                visited[next] = true;
                unionParent(next, cards[next - 1]);
                next = cards[next - 1];
            }
            
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        IntStream.range(1, cards.length + 1)
            .map(i -> parent[i])
            .forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        
        List<Map.Entry<Integer, Integer>> result = map.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
            .collect(Collectors.toList());
        
        for(Map.Entry<Integer, Integer> l : result) System.out.println(l.getValue());
        
        if(result.size() < 2) return 0;
        
        for(int i = 0 ; i < 2 ; i++) answer *= result.get(i).getValue();
        
        return answer;
    }
}