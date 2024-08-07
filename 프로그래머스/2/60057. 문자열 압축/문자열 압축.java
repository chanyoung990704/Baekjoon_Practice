import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        int len = s.length();
        
        if(len == 1) return 1;
        
        for(int i = 1 ; i <= len / 2 ; i++) {
            String res = "";
            String prev = "";
            int cnt = 1;
            int idx = 0;
            
            while(idx < len) {
                String cur = s.substring(idx,
                    Math.min(len, idx + i));
                
                // 연속 확인
                if(!prev.equals(cur)){
                    if(cnt == 1) res += prev;
                    else res += String.valueOf(cnt) + prev;
                    prev = cur;
                    cnt = 1;
                }else{
                    cnt++;
                }
                
                idx += i;
            }
            
            if(cnt == 1) res += prev;
            else res += String.valueOf(cnt) + prev;
            
            answer = Math.min(answer, res.length());
        }
        
        
        return answer;
    }
}