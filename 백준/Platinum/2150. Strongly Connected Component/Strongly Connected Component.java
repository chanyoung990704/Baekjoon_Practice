import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static boolean[] onStack;
    static Stack<Integer> stack = new Stack<>();

    static int idx = 0;
    static int[] ids;
    static int[] low;

    static List<List<Integer>> graph = new ArrayList<>();
    static List<List<Integer>> res = new  ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] VE = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int V = VE[0];
        int E = VE[1];

        // SCC
        onStack = new boolean[V+1];
        ids = new int[V + 1];
        low = new int[V + 1];
        Arrays.fill(ids, -1);

        for(int i = 0; i <= V; i++){
           graph.add(new ArrayList<>());
        }

        // set up graph
        for (int i = 0; i < E; i++) {
            int[] ft = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(ft[0]).add(ft[1]);
        }

        for(int i = 1; i <= V; i++){
            if(ids[i] == -1){
                dfs(i);
            }
        }

        res.sort(Comparator.comparing((List<Integer> list) -> list.get(0)));

        
        System.out.println(res.size());
        for (List<Integer> r : res) {
            System.out.println(r.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }

    }

    private static void dfs(int at) {
        onStack[at] = true;
        stack.push(at);
        low[at] = ids[at] = idx++;

        for(int to : graph.get(at)){
            if(ids[to] == -1){
                dfs(to);
            }
            if (onStack[to]) {
                low[at] = Math.min(low[at], low[to]);
            }
        }

        // make SCC
        if(low[at] == ids[at]){
            List<Integer> scc = new ArrayList<>();

            while (true) {
                int node = stack.pop();
                scc.add(node);
                onStack[node] = false;
                low[node] = low[at];

                if (node == at) {
                    break;
                }
            }

            scc.sort(Comparator.naturalOrder());
            scc.add(-1);
            res.add(scc);
        }

    }
}
