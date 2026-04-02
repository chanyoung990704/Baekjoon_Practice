import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        
        Stack<int[]> stack = new Stack<>();
        
        int[] answer = new int[prices.length];
        int time = 0;
        
        for(int i = 0 ; i < prices.length ; i++){
            time++;
            
            // 현재
            int price = prices[i];
            // 감소한 거 뺴기
            while(!stack.isEmpty() && prices[stack.peek()[0]] > price){
                int[] s = stack.pop();
                answer[s[0]] = time - s[1];
            }
            
            stack.push(new int[]{i, time});
            
        }
        
        // 남아있는 거 정리
        while(!stack.isEmpty()){
            int[] s = stack.pop();
            answer[s[0]] = time - s[1];
        }
        
        return answer;
    }
}