import java.util.*;
import java.util.stream.*;

class Solution {
    
    class Food{
        int idx;
        int cnt;
        Food(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
        int getIdx(){return idx;}
        int getCnt(){return cnt;}
        
    }
    
    public int solution(int[] food_times, long k) {
        int answer = 0;
        
        PriorityQueue<Food> pq = 
            new PriorityQueue<>(Comparator.comparing(Food::getCnt));
        for(int i = 0 ; i < food_times.length ; i++){
            pq.offer(new Food(i + 1, food_times[i]));
        }
        
        long totalTime = 0;
        long prevTime = 0;
        int len = pq.size();
        
        while(!pq.isEmpty()){
            Food cur = pq.peek();
            long diff = cur.getCnt() - prevTime;
            long t = diff * len;
            
            if(totalTime + t > k) break;
            totalTime += t;
            prevTime = pq.poll().getCnt();
            len--;
        }
        
        if(pq.isEmpty()) return -1;
        
        k -= totalTime;
        List<Integer> res = pq.stream()
            .map(f -> f.getIdx())
            .sorted()
            .collect(Collectors.toList());
        answer = res.get((int) (k % len));
        
        return answer;
    }
}