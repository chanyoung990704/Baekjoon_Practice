import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String number, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0 ; i < number.length() ; i++){
            int cur = number.charAt(i) - '0';
            
            // 현재가 가능한 최대가 되게
            while(!dq.isEmpty() && k > 0 && dq.peekLast() < cur){
                k--;
                dq.pollLast();
            }
            
            dq.offerLast(cur);
        }
        
        while(k > 0){
            k--;
            dq.pollLast();
        }
        
        return dq.stream().map(String::valueOf).collect(Collectors.joining());
    }
}