import java.util.*;
import java.util.stream.*;

class Solution {
    
    class Data{
        int idx;
        int cnt;
        Data(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    
    
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        PriorityQueue<Data> deliveryQ = new PriorityQueue<>(Comparator.comparing((Data d) -> d.idx).reversed());
        PriorityQueue<Data> pickupQ = new PriorityQueue<>(Comparator.comparing((Data d) -> d.idx).reversed());
        for(int i = 0 ; i < n ; i++){
            if(deliveries[i] > 0)
                deliveryQ.offer(new Data(i + 1, deliveries[i]));
            if(pickups[i] > 0)
                pickupQ.offer(new Data(i + 1, pickups[i]));
        }
        
        long answer = 0;

        while(!deliveryQ.isEmpty() || !pickupQ.isEmpty()){
            
            // 큐 갱신하기
            int d = 0;
            int maxd = 0;
            while(!deliveryQ.isEmpty() && d < cap){
                Data cur = deliveryQ.poll();
                maxd = Math.max(maxd, cur.idx);
                d += cur.cnt;
                if(d > cap){
                    deliveryQ.offer(new Data(cur.idx, d - cap));
                    d = cap;
                }
            }
 
            int p = 0;
            while(!pickupQ.isEmpty() && p < cap){
                Data cur = pickupQ.poll();
                maxd = Math.max(maxd, cur.idx);
                p += cur.cnt;
                if(p  > cap){
                    pickupQ.offer(new Data(cur.idx, p - cap));
                    p = cap;
                }
            }            
            
            answer += maxd * 2;
            
        }
        
        return answer;
    }
}