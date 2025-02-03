import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        // graph init
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 1 ; i < list.size() ; i++){
            graph.get(i).add(list.get(i));
            graph.get(list.get(i)).add(i);
        }

        // 0번부터 DFS
        boolean[] visited = new boolean[N];
        int result = dfs(0, graph, visited);

        System.out.println(result);
    }

    static int dfs(int cur, List<List<Integer>> graph, boolean[] visited) {
        visited[cur] = true;
        if(graph.get(cur).isEmpty()){
            return 0;
        }
        List<Integer> times = new ArrayList<>();
        
        for(int next : graph.get(cur)) {
            if(!visited[next]) { // 방문 안 한 노드만 처리 (자식 노드)
                times.add(dfs(next, graph, visited));
            }
        }
        
        Collections.sort(times, Collections.reverseOrder());
        int max = 0;
        for(int i = 0; i < times.size(); i++) {
            max = Math.max(max, times.get(i) + i + 1);
        }
        return max;
    }
}

