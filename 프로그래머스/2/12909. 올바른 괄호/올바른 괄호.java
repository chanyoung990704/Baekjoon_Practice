import java.util.*;

class Solution {
    boolean solution(String s) {        
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            // (일 경우
            if(c == '(')
                stack.push(c);
            // )일 경우
            else{
                if(!stack.empty())
                    stack.pop();
                else
                    return false;
            }  
        }
    
        if(!stack.empty())
            return false;
        
        return true;
    }
}