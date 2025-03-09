import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] bridge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int A = bridge[0];
            int B = bridge[1];
            int C = bridge[2];
            
            graph.get(A).add(new int[]{B, C});
            graph.get(B).add(new int[]{A, C});
        }

        int[] ft = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int f = ft[0];
        int t = ft[1];

        int lo = 1;
        int hi = 1_000_000_000;
        int ret = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            boolean possible = bfs(graph, f, t, mid, N);

            if (possible) {
                ret = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ret);
    }

    private static boolean bfs(Map<Integer, List<int[]>> graph, int start, int target, int minWeight, int N) {
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);

        while (!dq.isEmpty()) {
            int cur = dq.poll();
            if (cur == target) {
                return true;
            }

            for (int[] next : graph.get(cur)) {
                int nextNode = next[0];
                int weight = next[1];

                if (!visited[nextNode] && weight >= minWeight) {
                    visited[nextNode] = true;
                    dq.offer(nextNode);
                }
            }
        }

        return false;
    }
}
