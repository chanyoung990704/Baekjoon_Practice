import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> VE = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int V = VE.get(0);
        int E = VE.get(1);

        List<List<Integer>> graph = new ArrayList<>();

        // 간선 입력
        for(int i = 0 ; i < E ; i++){
            List<Integer> input = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            graph.add(input); 
        }

        graph.sort(Comparator.comparing((List<Integer> l) -> l.get(2)));

        int[] parent = new int[V + 1];
        for(int i = 0 ; i <= V ; i++){
            parent[i] = i;
        }

        // 최소 스패닝 트리 구하기
        int total = 0;
        for(List<Integer> cur : graph){
            int a = cur.get(0);
            int b = cur.get(1);
            int w = cur.get(2);

            // 사이클이 아니면 유니온
            if(findParent(parent, a) != findParent(parent, b)){
                total += w;
                union(a, b, parent);
            }
        }

        System.out.println(total);
    }

    static int findParent(int[] parent, int cur){
        if(parent[cur] != cur){
            parent[cur] = findParent(parent, parent[cur]);
        }
        return parent[cur];
    }

    static void union(int a, int b, int[] parent){
        int rootA = findParent(parent, a);
        int rootB = findParent(parent, b);

        // 작은 것을 가리키게
        if(rootA > rootB){
            parent[rootA] = rootB;
        }else{
            parent[rootB] = rootA;
        }
    }
}
