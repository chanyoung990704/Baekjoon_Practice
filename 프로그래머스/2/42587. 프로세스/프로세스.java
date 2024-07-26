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
        
        int getPriority(){
            return this.priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
                                                         
        Deque<Process> waitingQueue = new ArrayDeque<>();
        PriorityQueue<Process> pq = new PriorityQueue<>(
        Comparator.comparing(Process::getPriority).reversed());
        
        for(int i = 0 ; i < priorities.length ; i++){
            pq.offer(new Process(i, priorities[i]));
            waitingQueue.offer(new Process(i, priorities[i]));
        }
        
        int cnt = 0;
        // 로직       
        while(!waitingQueue.isEmpty()){
            Process cur = waitingQueue.pollFirst();
            // 실행
            if(cur.getPriority() == pq.peek().getPriority()){
                cnt++;
                pq.poll();
                if(cur.idx == location){
                    return cnt;
                }
            }else{
                waitingQueue.offer(cur);
            }
            
            
        }
        
        return -1;
        
    }
}