import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx;
        int weight;
        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static int maxLen = 0;
    static int maxIdx = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int idx = Integer.parseInt(input[0]);
            int j = 1;
            while (true) {
                int next = Integer.parseInt(input[j]);
                if (next == -1) break;
                int weight = Integer.parseInt(input[j + 1]);
                graph.get(idx).add(new Node(next, weight));
                j += 2;
            }
        }

        // 첫 번째 DFS
        boolean[] visited = new boolean[N + 1];
        dfs(1, 0, graph, visited);

        // 두 번째 DFS
        Arrays.fill(visited, false);
        maxLen = 0;
        dfs(maxIdx, 0, graph, visited);

        System.out.println(maxLen);
    }

    private static void dfs(int idx, int sum, List<List<Node>> graph, boolean[] visited) {
        visited[idx] = true;

        if (sum > maxLen) {
            maxLen = sum;
            maxIdx = idx;
        }

        for (Node next : graph.get(idx)) {
            if (!visited[next.idx]) {
                dfs(next.idx, sum + next.weight, graph, visited);
            }
        }
    }
}
