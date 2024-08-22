import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(int n, int[] works) {        
        long total = Arrays.stream(works)
                           .sum();
        
        
        if(total <= n) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int work : works) pq.offer(work);
        
        while(!pq.isEmpty() && n > 0) {
            int max = pq.poll();
            if(max > 0) pq.offer(max - 1);
            n--;
        }        
 
        return pq.stream()
                 .mapToLong(i -> i * i)
                 .sum();
  
    }
}