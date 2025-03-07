import java.util.*;

class Solution {
    public int[] solution(int[] prices) {    
        int n = prices.length;
        int[] answer = new int[n];
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0 ; i < n ; i++){
            // 떨어지는 순간
            while(!dq.isEmpty() && prices[i] < prices[dq.peekLast()]){
                answer[dq.peekLast()] = i - dq.peekLast();
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        
        while(!dq.isEmpty()){
            int idx = dq.pollLast();
            answer[idx] = n - 1 - idx;
        }
        
        
        return answer;
    }
}