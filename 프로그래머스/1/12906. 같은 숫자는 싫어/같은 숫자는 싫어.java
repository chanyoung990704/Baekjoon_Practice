import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        for(int n : arr){
            if(!stack.isEmpty() && stack.peek() == n){
                continue;
            }
            stack.push(n);
        }
        
        int[] answer = new int[stack.size()];
        for(int j = answer.length - 1 ; j >= 0 ; j--){
            answer[j] = stack.pop();
        }

        return answer;
    }
}