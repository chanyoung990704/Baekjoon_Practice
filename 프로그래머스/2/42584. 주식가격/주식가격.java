import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++) {
            
            while(!dq.isEmpty() && prices[i] < prices[dq.peekLast()]){
                int top = dq.pollLast();
                answer[top] = i - top;
            }
            
            dq.offer(i);
        }

        while(!dq.isEmpty()){
            int top = dq.pollLast();
            answer[top] = n - 1 - top;
        }
        
        return answer;
    }
}