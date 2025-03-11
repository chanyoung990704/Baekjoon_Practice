import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<Integer> running = new ArrayDeque<>();
        Deque<Integer> trucks = new ArrayDeque<>(Arrays.stream(truck_weights).boxed()
                                                 .collect(Collectors.toList()));
        for(int i = 0 ; i < bridge_length ; i++){
            running.offer(0);
        }
        
        int time = 0;
        int curWeight = 0;
        int curSize = 0;
        
        while(!running.isEmpty() || !trucks.isEmpty()){
            
            // 러닝 큐를 한칸씩 이동
            if(!running.isEmpty()){
                curWeight -= running.pollFirst();
                curSize -= 1;
            }
            
            // 무게 & 용량 확인 후 푸시
            if(!trucks.isEmpty()){
                int next = trucks.peekFirst();
                if(curWeight + next <= weight && curSize + 1 <= bridge_length){
                    curWeight += next;
                    curSize += 1;
                    running.offerLast(next);
                    trucks.pollFirst();
                }else{
                    running.offerLast(0);
                }
            }
            
            time++;
        }
        return time;
    }
}