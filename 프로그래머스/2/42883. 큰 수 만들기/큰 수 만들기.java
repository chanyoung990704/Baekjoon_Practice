import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(char n : number.toCharArray()){
            int cur = n - '0';
            while(!q.isEmpty() && k > 0 && q.peekLast() < cur){
                k--;
                q.pollLast();
            }
            q.offer(cur);
        }
        
        while(k > 0){
            k--;
            q.pollLast();
        }
        
        return q.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
    }
}