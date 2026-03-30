import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int V, E;

    static List<List<Integer>> adj = new ArrayList<>();

    static int[] low;
    static int[] order;
    static boolean[] isTrue; // 단절점
    static int timer = 1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        low = new int[V + 1];
        order = new int[V + 1];
        isTrue = new boolean[V + 1];
        // 단절점 구하기
        for (int i = 1; i <= V; i++) {
            if (order[i] == 0) {
                dfs(i, 0, true);
            }
        }

        int cnt = 0;
        for (int i = 1; i <= V; i++) {
            if (isTrue[i]) {
                cnt++;
                sb.append(i).append(" ");
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

    private static int dfs(int node, int parent, boolean isRoot) {
        order[node] = low[node] = timer++;
        int childCnt = 0;

        for (int child : adj.get(node)) {
            if (child == parent) continue;

            if (order[child] == 0) { // 자식 노드 방문
                childCnt++;
                int childLow = dfs(child, node, false);
                low[node] = Math.min(low[node], childLow);

                if (!isRoot && childLow >= order[node]) {
                    isTrue[node] = true;
                }
            } else {
                low[node] = Math.min(low[node], order[child]);
            }
        }

        if (isRoot && childCnt >= 2) isTrue[node] = true;
        return low[node];
    }
}
