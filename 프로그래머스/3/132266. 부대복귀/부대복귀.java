import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 지역 수 n 지역 왕복 길 정보 roads
        // 부대원 위치 서로 다른 지역 sources
        // 강철부대 지역 destination
        
        
        // destination부터 다익스트라
        
        // 간선 입력
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] r : roads){
            graph.computeIfAbsent(r[0], k->new ArrayList<>()).add(r[1]);
            graph.computeIfAbsent(r[1], k->new ArrayList<>()).add(r[0]);
        }
        
        // 거리
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[destination] = 0;
        
        // 거리, 인덱스 거리 최소힙
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0, destination});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int i = cur[1];
            int d = cur[0];
            
            if(dist[i] < d){
                continue;
            }
            
            // 이동
            for(int next : graph.get(i)){
                int nextD = d + 1;
                if(dist[next] > nextD){
                    dist[next] = nextD;
                    pq.offer(new int[]{nextD, next});
                }
            }
        }
        
        // source 순으로 거리 출력
        int[] answer = new int[sources.length];
        for(int i = 0 ; i < sources.length ; i++){
            answer[i] = dist[sources[i]] == Integer.MAX_VALUE ? -1 : dist[sources[i]];
        }
        
        return answer;
    }
}