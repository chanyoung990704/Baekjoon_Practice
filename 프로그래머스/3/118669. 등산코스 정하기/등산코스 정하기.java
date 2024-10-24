import java.util.*;
import java.util.stream.*;

class Solution {
    int n;
    Set<Integer> gates, summits;
    List<List<Node>> adj = new ArrayList<>();
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        this.n = n;
        this.gates = convertSet(gates);
        this.summits = convertSet(summits);
        
        // init adj
        for(int i = 0 ; i < n + 1 ; i++) adj.add(new ArrayList<>());
        for(int[] path : paths){
            adj.get(path[0]).add(new Node(path[1], path[2]));
            adj.get(path[1]).add(new Node(path[0], path[2]));
        }
        
        // dajikstra
        return dajikstra();
    }
    
    int[] dajikstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing((Node n) -> n.w));
        int[] weights = new int[n + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        
        // 다중 출발지 다익스트라
        for(int gate : gates) {
            pq.offer(new Node(gate, 0));
            weights[gate] = 0;
        }
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(weights[cur.idx] < cur.w) continue;
            if(summits.contains(cur.idx)) continue;
            
            for(Node next : adj.get(cur.idx)){
                int nextWeight = Math.max(cur.w, next.w);
                if(weights[next.idx] > nextWeight && !gates.contains(next.idx)){
                    weights[next.idx] = nextWeight;
                    pq.offer(new Node(next.idx, nextWeight));
                }
            }
        }
        
        List<Node> result =  summits.stream()
                             .map(i -> new Node(i, weights[i]))
                             .sorted(Comparator.comparing((Node n) -> n.w)
                                    .thenComparing((Node n) -> n.idx))
                             .collect(Collectors.toCollection(ArrayList::new));
        
        return new int[]{result.get(0).idx, result.get(0).w};
    }
    
    Set<Integer> convertSet(int[] arr){
        return Arrays.stream(arr)
                     .boxed()
                     .collect(Collectors.toCollection(HashSet::new));
    }
    
    static class Node{
        int idx;
        int w;
        
        Node(int idx, int w){
            this.idx = idx;
            this.w = w;
        }
    }
}