import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 큐 무게, [] 무게, 시작 시점, 현재 시간
        
        int time = 0;
        int bridge_weight=0;
        Queue<int[]> q = new ArrayDeque<>();
        int finished = 0;
        int idx = 0;
        
        while(true){
            // 다 지났으면
            if(finished == truck_weights.length){
                break;
            }
            
            // 시간 증가
            time++;
            
            // 큐에서 빠질 것들 체크
            while(!q.isEmpty() && time - q.peek()[1] >= bridge_length){
                bridge_weight -= q.poll()[0];
                finished++;
            }
            
            // 트럭 진입
            if(idx < truck_weights.length && bridge_weight + truck_weights[idx] <= weight){
                bridge_weight += truck_weights[idx];
                q.offer(new int[]{truck_weights[idx++], time});
            }
            
            
        }
 
        return time;
    }
}