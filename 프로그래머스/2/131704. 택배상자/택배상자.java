import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Deque<Integer> container = new ArrayDeque<>();
        Deque<Integer> assister = new ArrayDeque<>();
        
        // 초기화
        for(int i = 1 ; i <= order.length ; i++){
            container.offer(i);
        }
        
        // 로직
        int idx = 0;
        while(idx < order.length){
            
            // 보조 컨테이너 먼저 일치 확인
            if(!assister.isEmpty() && assister.peekLast() == order[idx]){
                idx++;
                answer++;
                assister.pollLast();
                continue;
            }
            
            // 컨테이너 확인
            while(!container.isEmpty() && container.peekFirst() != order[idx]){
                assister.offer(container.pollFirst());
            }
            
            // 일치하면 idx 넘긴다
            if(!container.isEmpty()){
                idx++;
                answer++;
                container.pollFirst();
                continue;
            }
            
            break;
            
        }
        
        return answer;
    }
}