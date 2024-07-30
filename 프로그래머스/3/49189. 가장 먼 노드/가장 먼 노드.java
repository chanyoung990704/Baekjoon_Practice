import java.util.*;
import java.util.stream.*;

class Solution {
    
    class ToCost{
        int idx;
        int cost;
        
        ToCost(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        
        int getIdx(){return idx;}
        int getCost(){return cost;}
    }
    
    public int solution(int n, int[][] edge) {
        
        
        // 다익스트라
        List<List<ToCost>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        // 간선 초기화
        for(int[] e : edge){
            adj.get(e[0]).add(new ToCost(e[1], 1));
            adj.get(e[1]).add(new ToCost(e[0], 1));
        }
        
        // 거리 저장
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<ToCost> pq = 
            new PriorityQueue<>(Comparator.comparing(ToCost::getCost)
                               .thenComparing(Comparator.comparing(ToCost::getIdx)));
        
        pq.offer(new ToCost(1, 0));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            ToCost cur = pq.poll();
            if(cur.cost > dist[cur.idx]){
                continue;
            }
            
            for(ToCost ne : adj.get(cur.idx)){
                int nextCost = cur.cost + ne.cost;
                if(nextCost < dist[ne.idx]){
                    dist[ne.idx] = nextCost;
                    pq.offer(new ToCost(ne.idx, nextCost));
                }
            }
        }
        
        // 최대 멀리 있는 값
        
        return (int) IntStream.range(1, n + 1)
            .map(i -> dist[i])
            .filter(i -> i == IntStream.range(1, n + 1)
                    .map(j -> dist[j])
                    .max().orElse(0)
                   )
            .count();
            
    }
}