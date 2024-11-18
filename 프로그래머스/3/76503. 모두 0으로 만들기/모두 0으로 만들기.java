import java.util.*;
import java.util.stream.*;

class Solution {
    static long[] ai;
    int[][] edges;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public long solution(int[] a, int[][] edges) {
        ai = new long[a.length];
        for(int i = 0 ; i < a.length ; i++) ai[i] = a[i];
        this.edges = edges;
        
        long totalSum = Arrays.stream(a).sum();
        if(totalSum != 0) return -1;        
        
        for(int i = 0 ; i < a.length ; i++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < edges.length ; i++){
            int[] e = edges[i];
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        visited = new boolean[a.length];
        dfs(0, visited);
        
        return ai[0];
    }
    
    long dfs(int s, boolean[] visited) {
        
        visited[s] = true;
        long cnt = ai[s];
        long w = 0;
        for(int i = 0 ; i < graph.get(s).size() ; i++){
            int next = graph.get(s).get(i);
            if(!visited[next]) {
                long val = dfs(next, visited);
                cnt += val;
                w += (Math.abs(val) + ai[next]);
            }
        }
        ai[s] = w;
        return cnt;
    }
}