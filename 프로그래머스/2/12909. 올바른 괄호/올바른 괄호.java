import java.util.*;
import java.util.stream.*;

class Solution {
    boolean solution(String s) {
        
        Deque<Character> dq = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            if(c == '('){
                dq.offerLast(c);
                continue;
            }
            
            // 닫는 괄호 예외
            if(c == ')' && dq.isEmpty()){
                return false;
            }else{
                dq.pollLast();
            }
        }
        
        
        return dq.isEmpty();
    }
}