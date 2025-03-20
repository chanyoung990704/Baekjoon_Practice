import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 다익스트라
    
        // 노드 수 n 간선 정보 edge
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // 1번부터 다익스트라
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 1});
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        int max = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int idx = cur[1];
            int d = cur[0];
            // 불가능
            if(dist[idx] < d){
                continue;
            }
        
            for(int next : graph.get(idx)){
                int nextDist = d + 1;
                if(dist[next] > nextDist){
                    dist[next] = nextDist;
                    pq.offer(new int[]{nextDist, next});
                    max = Math.max(max, nextDist);
                }
            }
        }
        
        int answer = 0;
        // 순회
        for(int i = 1 ; i <= n ; i++){
            if(dist[i] == max){
                answer++;
            }
        }
        return answer;
    }
}