import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int num;
        int val;
        Node(int num, int val){
            this.num = num;
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(input[0]).add(new Node(input[1], input[2]));
            graph.get(input[1]).add(new Node(input[0], input[2]));
        }

        // daijkstra
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        int[] prev = new int[N+1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int idx = cur[0];
            int total = cur[1];

            if(total > dist[idx]){
                continue;
            }

            for(Node node : graph.get(idx)){
                int nextIdx = node.num;
                int nextTotal = total + node.val;

                if(dist[nextIdx] > nextTotal){
                    dist[nextIdx] = nextTotal;
                    pq.offer(new int[]{nextIdx, nextTotal});
                    prev[nextIdx] = idx;
                }
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++){
            if(prev[i] != 0){
                sb.append(prev[i] + " "+ i + "\n");
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}
