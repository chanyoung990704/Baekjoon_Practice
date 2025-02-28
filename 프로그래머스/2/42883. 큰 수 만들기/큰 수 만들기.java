import java.util.*;

class Solution {
    public String solution(String number, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        
        for(char c : number.toCharArray()){
            int n = c - '0';
            
            // 큰 값이 스택의 아래쪽에 위치하도록
            while(!dq.isEmpty() && n > dq.peekLast() && k > 0){
                dq.pollLast();
                k--;
            }
            
            dq.offerLast(n);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            sb.append(dq.pollFirst());
        }
        
        return sb.substring(0, sb.length() - k).toString();
    }
}