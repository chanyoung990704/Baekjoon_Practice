import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        parent = new int[n+1];
        
        for (int i = 0; i < wires.length; i++) {
            // Try cutting each wire
            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }
            
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // Skip the cut wire
                union(wires[j][0], wires[j][1]);
            }
            
            // Count the sizes of the two components
            int size1 = 0;
            int root = find(1);
            for (int j = 1; j <= n; j++) {
                if (find(j) == root) size1++;
            }
            int size2 = n - size1;
            
            // Update the answer
            answer = Math.min(answer, Math.abs(size1 - size2));
        }
        
        return answer;
    }
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}