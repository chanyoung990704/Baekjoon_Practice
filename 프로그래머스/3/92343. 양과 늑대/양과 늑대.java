import java.util.*;

class Solution {
    private int[] info;
    private List<List<Integer>> graph;
    private int maxSheep;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        Set<Integer> nextNodes = new HashSet<>();
        nextNodes.add(0);
        boolean[] visited = new boolean[info.length];
        dfs(0, 0, 0, nextNodes, visited);
        
        return maxSheep;
    }

    private void dfs(int node, int sheep, int wolf, Set<Integer> nextNodes, boolean[] visited) {
        if (info[node] == 0) sheep++;
        else wolf++;
        
        if (wolf >= sheep) return;
        
        maxSheep = Math.max(maxSheep, sheep);
        
        Set<Integer> newNextNodes = new HashSet<>(nextNodes);
        newNextNodes.remove(node);
        newNextNodes.addAll(graph.get(node));
        
        for (int next : newNextNodes) {
            if (!visited[next]) {
                boolean[] newVisited = Arrays.copyOfRange(visited, 0, visited.length);
                newVisited[next] = true;
                dfs(next, sheep, wolf, newNextNodes, newVisited);
            }
        }
    }
}