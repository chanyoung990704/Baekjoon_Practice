import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            adj.add(new ArrayList<>());
        }

        // 연결관계
        for(int i = 0 ; i < N - 1 ; i++) {
            List<Integer> ft = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            int from = ft.get(0);
            int to = ft.get(1);
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        // dfs
        int[] parent = new int[N + 1];
        Arrays.fill(parent, -1); // -1이면 방문 안한 것

        dfs(1, parent, adj);
        parent[1] = 1;

        for(int i = 2 ; i <= N ; i++){
            System.out.println(parent[i]);
        }
    }

    static void dfs(int cur, int[] parent, List<List<Integer>> adj){
        
        for(int next : adj.get(cur)){
            if(parent[next] == -1){
                parent[next] = cur;
                dfs(next, parent, adj);
            }
        }
    }
}
