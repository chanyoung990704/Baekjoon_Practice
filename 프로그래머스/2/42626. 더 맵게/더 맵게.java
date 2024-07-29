import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>((a, b) -> a - b);
        
        // 초기화
        Arrays.stream(scoville)
            .forEach(i -> {
                pq.offer(i);
            });
        
        // 로직
        int cnt = 0;
        while(!pq.isEmpty() && pq.peek() < K) {
            // 개수가 1개일 때
            if(pq.size() == 1){
                return -1;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + (second * 2));
            cnt++;
            
        }
                
        return cnt;

    }
}