import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> minArrive = new PriorityQueue<>(
                                    Comparator.comparing((a) -> a[0]));
        PriorityQueue<int[]> minWork = new PriorityQueue<>(
                                    Comparator.comparing((a) -> a[1]));
        
        for(int[] job : jobs) minArrive.offer(job);
        
        int cnt = 0;
        int curT = 0;
        
        while(cnt < jobs.length) {
            // 현재 시점에서 가능한 작업들 모두 minWork로
            while(!minArrive.isEmpty() && minArrive.peek()[0] <= curT)
                minWork.offer(minArrive.poll());
            
            if(minWork.isEmpty()) curT = minArrive.peek()[0];
            else{
                int[] cur = minWork.poll();
                int waitingTime = curT - cur[0];
                
                curT += cur[1];
                answer += waitingTime + cur[1];
                
                cnt++;
                
            }
            
        }
        
        return answer / jobs.length;
    }
}