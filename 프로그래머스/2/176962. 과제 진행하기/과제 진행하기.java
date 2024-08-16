import java.util.*;
import java.util.stream.*;

class Solution {
    class Plan{
        String name;
        int start;
        int end;
        
        Plan(String name, int start, int end){
            this.name = name;
            this.start = start;
            this.end = end;
        }
        String getName(){return name;}
        int getStart(){return start;}
        int getEnd(){return end;}
        
    }
    
    class QueuePlan{
        String name;
        int remain;
        
        QueuePlan(String name, int remain){
            this.name = name;
            this.remain = remain;
        }
    }
    
    public String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        
        PriorityQueue<Plan> pq = new PriorityQueue<>(Comparator.comparing(Plan::getStart));
        for(String[] plan : plans){
            pq.offer(new Plan(plan[0], getMinute(plan[1]), getMinute(plan[1]) + Integer.valueOf(plan[2])));
        }
        
        Deque<QueuePlan> waitingQueue = new ArrayDeque<>();
        
        while(!pq.isEmpty()) {
            Plan cur = pq.poll();
            
            // 현재에서 다음 것 확인
            if(!pq.isEmpty()){
                int remain = pq.peek().getStart() - cur.getEnd();
                // 여유 시간이 있는 경우
                if(remain >= 0){
                    result.add(cur.getName());
                    while(!waitingQueue.isEmpty() && remain > 0){
                       QueuePlan qp = waitingQueue.pollLast();
                        // 완료 가능한 경우
                        if(qp.remain <= remain){
                            remain -= qp.remain;
                            result.add(qp.name);
                        }else{
                            waitingQueue.offer(new QueuePlan(qp.name, qp.remain - remain));
                            remain = 0;
                        }
                    }
                }else{
                    waitingQueue.offer(new QueuePlan(cur.getName(), Math.abs(remain)));
                }
                
                
            }else result.add(cur.getName());
            
        }
        
        // 마지막 waiting 큐 단계 처리
        while(!waitingQueue.isEmpty()) result.add(waitingQueue.pollLast().name);
        
        return result.stream().toArray(String[]::new);
    }
    
    int getMinute(String t){
        int[] parts = Arrays.stream(t.split(":"))
            .mapToInt(Integer::valueOf)
            .toArray();
        int h, m;
        h = parts[0]; m = parts[1];
        return h * 60 + m;
    }
}