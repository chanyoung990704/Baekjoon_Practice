import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) list.add(new ArrayList<>());
        for(int[] road : roads){
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        
        // 다익스트라
        int[] dist = new int[n + 1];
        for(int i = 0 ; i <= n ; i++) Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing((a) -> a.get(1)));
        pq.offer(List.of(destination, 0));
        dist[destination] = 0;
        
        while(!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            if(cur.get(1) > dist[cur.get(0)]) continue;
            
            for(int next : list.get(cur.get(0))){
                int nextCost = cur.get(1) + 1;
                if(dist[next] > nextCost){
                    dist[next] = nextCost;
                    pq.offer(List.of(next, nextCost));
                }
            }
            
        }
                
        return Arrays.stream(sources)
            .map(i -> {
                if(dist[i] == Integer.MAX_VALUE) return -1;
                else return dist[i];
            })
            .toArray();
    }
}