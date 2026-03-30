import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int V, E;

    static List<List<Integer>> adj = new ArrayList<>();

    static List<int[]> res = new ArrayList<>();

    static int[] order;
    static int[] low;
    static boolean[] isTrue;

    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 초기화
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        // 간선
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // 단절점 DFS
        order = new int[V + 1];
        low = new int[V + 1];
        isTrue = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (order[i] == 0) {
                dfs(i, 0);
            }
        }

        // 정렬
        res.sort(Comparator.comparing((int[] a) -> a[0])
                .thenComparing(a -> a[1]));

        sb.append(res.size()).append("\n");
        for (int[] r : res) {
            sb.append(r[0]).append(" ").append(r[1]).append("\n");
        }

        System.out.println(sb);
    }

    private static int dfs(int node, int parent) {
        order[node] = low[node] = cnt++;

        for (int next : adj.get(node)) {
            if (next == parent) {
                continue;
            }

            // 자식 방문
            if (order[next] == 0) {
                int childLow = dfs(next, node);
                low[node] = Math.min(low[node], childLow);

                // 단절선 확인
                if ( order[node] < childLow) {
                    int min = Math.min(node, next);
                    int max = Math.max(node, next);
                    res.add(new int[]{min, max});
                }
            }
            // 트리 최소 높이 갱신
            else{
                low[node] = Math.min(low[node], order[next]);
            }

        }

        return low[node];
    }
}
