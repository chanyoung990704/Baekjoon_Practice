import java.util.*;
import java.util.stream.*;

class Solution {
    
    class Process{
        int idx;
        int priority;
        
        Process(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        
        // Process 큐로 만들기
        Deque<Process> dq = new ArrayDeque<>(
            IntStream.range(0, priorities.length)
            .mapToObj(i -> new Process(i, priorities[i]))
            .collect(Collectors.toList())
        );
        
        int cnt = 0;
        
        while(!dq.isEmpty()){
            // 현재 확인
            Process cur = dq.pollFirst();
            
            boolean isMax = true;
            for(Process p : dq){
                if(p.priority > cur.priority){
                    isMax = false;
                    break;
                }
            }
            
            // 최대가 아니면
            if(!isMax){
                dq.offerLast(cur);
            }else{
                // 프로세스 실행
                cnt++;
                if(cur.idx == location){
                    return cnt;
                }
            }
        }
        
        return -1;
    }
}