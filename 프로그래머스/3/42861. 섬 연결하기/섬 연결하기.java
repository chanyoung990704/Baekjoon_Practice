import java.util.*;
import java.util.stream.*;

class Solution {
    
    Map<Integer, Integer> parent = new HashMap<>();
    
    int findParent(int n){
        if(!parent.containsKey(n)){
            parent.put(n, n);
        }else if(parent.get(n) != n){
            parent.put(n, findParent(parent.get(n)));
        }
        return parent.get(n);
    }
    
    void unionParent(int a, int b){
        if(findParent(a) < findParent(b)){
            parent.put(findParent(b), findParent(a));
        }else{
            parent.put(findParent(a), findParent(b));
        }
    }
    
    public int solution(int n, int[][] costs) {
        
        // 최소 간선 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        int answer = 0;
        
        for(int i = 0 ; i < costs.length ; i++){
            int t = costs[i][0];
            int f = costs[i][1];
            
            // 사이클이면 건너뛰기
            if(findParent(t) == findParent(f)){
                continue;
            }
            
            answer += costs[i][2];
            unionParent(t, f);
        }
        
        return answer;
    }
}