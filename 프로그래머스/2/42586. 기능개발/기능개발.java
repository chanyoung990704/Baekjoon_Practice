import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Deque<Integer> dq = IntStream.range(0, progresses.length)
            .map(i -> {
                int remain = 100 - progresses[i];
                int curSpeed = speeds[i];
                return remain % curSpeed == 0 ? remain / curSpeed 
                    : remain / curSpeed + 1;
            })
            .boxed()
            .collect(Collectors.toCollection(ArrayDeque::new));
        
        
        List<Integer> answer = new ArrayList<>();
        while(!dq.isEmpty()) {
            
            int day = dq.poll();
            int cnt = 1;
            
            while(!dq.isEmpty() && dq.peek() <= day){
                dq.poll();
                cnt++;
            }
            
            answer.add(cnt);
            
        }
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}