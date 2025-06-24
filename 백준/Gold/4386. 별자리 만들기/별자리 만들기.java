import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] parent;

    static int findParent(int a){
        if(parent[a] == a){
            return a;
        }
        parent[a] = findParent(parent[a]);
        return parent[a];
    }

    static void union(int a, int b){
        int ap =  findParent(a);
        int bp =  findParent(b);

        if(ap < bp){
            parent[bp] = ap;
        }else{
            parent[ap] = bp;
        }
    }

    static class Node{
        double val;
        int[] idx;
        public Node(double val, int[] idx){
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        parent = IntStream.range(0, n).toArray();

        List<double[]> idxs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idxs.add(Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray());
        }

//        for(double[] idx : idxs) {
//            System.out.println(Arrays.toString(idx));
//        }

        // 그래프
        double[][] graph = new  double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j){
                    graph[i][j] = -1.0;
                    continue;
                }
                graph[i][j] = Math.sqrt(Math.pow(idxs.get(i)[0] - idxs.get(j)[0], 2) + Math.pow(idxs.get(i)[1] - idxs.get(j)[1], 2));
            }
        }

        // System.out.println(Arrays.deepToString(graph));

        PriorityQueue<Node> pq = new  PriorityQueue<>(Comparator.comparingDouble(node -> node.val));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != j){
                    pq.offer(new Node(graph[i][j], new int[]{i,j}));
                }
            }
        }

        double sum = 0;
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            int a = cur.idx[0];
            int b = cur.idx[1];
            double val = cur.val;

            if(findParent(a) != findParent(b)){
                sum += val;
                union(a, b);
            }
        }

        System.out.printf("%.2f", sum);

    }
}