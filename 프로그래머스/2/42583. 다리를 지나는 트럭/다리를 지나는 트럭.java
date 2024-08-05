import java.util.*;

class Solution {
    
    class Truck{
        int weight;
        int start;
        
        Truck(int weight, int start){
            this.weight = weight;
            this.start = start;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int time = 0;
        int curWeight = 0;
        int idx = 0;
        Deque<Truck> q = new ArrayDeque<>();
        
        while(true){
            time++;
            
            // 빠져나갈 트럭 확인
            if(!q.isEmpty() && q.peekFirst().start + bridge_length == time){
                curWeight -= q.pollFirst().weight;
            }
            
            // 들어올 수 있는 트럭 확인
            if(idx < truck_weights.length && 
                 curWeight + truck_weights[idx] <= weight){
                q.offerLast(new Truck(truck_weights[idx], time));
                curWeight += truck_weights[idx];
                idx++;
            }
            
            if(q.isEmpty()){
                break;
            }

        }
        
        
        
        return time;
    }
}