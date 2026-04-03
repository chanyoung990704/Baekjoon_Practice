import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.offer(s);
        }
        
        // 0번인 경우
        int answer = 0;
        if(pq.peek() >= k){
            return answer;
        }
        
        while(pq.size() > 1){
            int p = pq.poll();
            int p2 = pq.poll();
            
            answer++;
            pq.offer(p + 2 * p2);
            
            if(pq.peek() >= k){
                break;
            }
        }
        
        return pq.peek() >= k ? answer : -1;
    }
}