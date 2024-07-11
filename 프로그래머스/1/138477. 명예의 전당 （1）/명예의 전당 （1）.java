import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < score.length ; i++) {
            
            pq.offer(score[i]);
            
            if(pq.size() > k)
                pq.poll();
            
            list.add(pq.peek());
        }
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
        
    }
}