import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> dq = new ArrayDeque<>();
        
        
        for(int i = numbers.length - 1 ; i >= 0 ; i--) {
            while(!dq.isEmpty() && numbers[dq.peekLast()] <= numbers[i]){
                dq.pollLast();
            }
            
            answer[i] = dq.isEmpty() ? -1 : numbers[dq.peekLast()];
            dq.offerLast(i);

        }
        
        
        
        return answer;
    }
}