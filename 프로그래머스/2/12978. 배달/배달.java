import java.util.*;
import java.util.stream.*;

class Solution {
    
    class Place{
        int idx;
        int cost;
        
        Place(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        
        int getIdx(){return idx;}
        int getCost(){return cost;}
    }
    
    public int solution(int N, int[][] road, int K) {

        
        List<List<Place>> adj = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++) adj.add(new ArrayList<>());
        
        for(int[] cur : road){
            adj.get(cur[0]).add(new Place(cur[1], cur[2]));
            adj.get(cur[1]).add(new Place(cur[0], cur[2]));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Place> pq = 
            new PriorityQueue<>(Comparator.comparing(Place::getCost));
        
        dist[1] = 0;
        pq.offer(new Place(1, 0));
        
        while(!pq.isEmpty()){
            Place cur = pq.poll();
            if(cur.getCost() > dist[cur.getIdx()]) continue;
            
            for(Place next : adj.get(cur.getIdx())){
                int nextCost = next.getCost() + cur.getCost();
                if(dist[next.getIdx()] > nextCost){
                    dist[next.getIdx()] = nextCost;
                    pq.offer(new Place(next.getIdx(), nextCost));
                }
            }
        }
        
        long cnt = IntStream.range(1, N + 1)
            .map(i -> dist[i])
            .filter(i -> i <= K)
            .count();
        
        return (int)cnt;
    }
}