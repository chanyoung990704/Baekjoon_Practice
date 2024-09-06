import java.util.*;
import java.util.stream.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        parent = new int[n];
        for(int i = 0 ; i < n ; i++) parent[i] = i;
        
        for(int[] cost : costs){
            // 사이클이 아닌 경우 추가
            if(findParent(cost[0]) != findParent(cost[1])) {
                unionParent(cost[0], cost[1]);
                answer += cost[2];
            }
        }
        
        return answer;
    }
    
    int findParent(int a) {
        if(parent[a] != a) parent[a] = findParent(parent[a]);
        return parent[a];
    }
    
    void unionParent(int a, int b){
        int rootA = findParent(a);
        int rootB = findParent(b);
        
        if(rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
}