import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for(int i = 0 ; i < parent.length ; i++) parent[i] = i;
        
        List<List<Integer>> indexes = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            int[] cur = getIntArr(br);
            indexes.add(List.of(cur[0], cur[1], cur[2], i));
        }

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing((List<Integer> cur) -> cur.get(2)));
        for(int i = 0 ; i < 3;  i++) {
            final int f = i;
            indexes.sort(Comparator.comparing((List<Integer> cur) -> cur.get(f)));
            for(int j = 1 ; j < indexes.size() ; j++){
                int node1 = indexes.get(j - 1).get(3);
                int node2 = indexes.get(j).get(3);
                int cost = Math.abs(indexes.get(j - 1).get(f) - indexes.get(j).get(f));
                pq.offer(List.of(node1, node2, cost));
            }
        }

        int cost = 0;
        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            if(findParent(cur.get(0)) != findParent(cur.get(1))){
                union(cur.get(0), cur.get(1));
                cost += cur.get(2);
            }
        }

        System.out.println(cost);
        br.close();
    }

    static int getCost(List<Integer> x, List<Integer> y){
        return Math.min(
            Math.min(Math.abs(x.get(0) - y.get(0)), Math.abs(x.get(1) - y.get(1)))    
        , Math.abs(x.get(2) - y.get(2)));
    }

    static int[] getIntArr(BufferedReader br) throws IOException{
        return Arrays.stream(br.readLine().split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    static void union(int a, int b){
        int rootA = findParent(a);
        int rootB = findParent(b);

        if(rootA != rootB){
            if(rootA > rootB){
                parent[rootA] = rootB;
            }else{
                parent[rootB] = rootA;
            }
        }
    }

    static int findParent(int node){
        if(node != parent[node]) parent[node] = findParent(parent[node]);
        return parent[node];
    }
}