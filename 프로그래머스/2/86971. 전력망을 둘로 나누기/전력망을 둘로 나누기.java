import java.util.*;
class Solution {
    
    int[] parent;
    
    int findParent(int n){
        if(n != parent[n]){
            parent[n] = findParent(parent[n]);
        }
        return parent[n];
    }
    
    void unionParent(int a, int b){
        int rootA = findParent(a);
        int rootB = findParent(b);
        
        if(rootA < rootB){
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        parent = new int[n + 1];
        
        for(int i = 0 ; i < wires.length ; i++) {
            for(int j = 1 ; j <= n ; j++){
                parent[j] = j;
            }
            
            for(int j = 0 ; j < wires.length ; j++){
                if(i == j) continue;
                unionParent(wires[j][0], wires[j][1]);
            }
            
            int size1 = 0;
            int root = findParent(1);
            for(int j = 1 ; j <= n ; j++){
                if(findParent(j) == root) size1++;
            }
            int size2 = n - size1;
            
            answer = Math.min(answer, Math.abs(size1 - size2));
        }
        
        
        return answer;
    }
}