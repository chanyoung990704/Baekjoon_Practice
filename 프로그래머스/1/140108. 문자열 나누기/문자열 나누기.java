import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String s) {
        
        int prevCnt = 0;
        int anotherCnt = 0;
        char prev = ' ';
        int result = 0;
        
        for(char c : s.toCharArray()) {
            
            if(prevCnt == 0) {
                prevCnt++;
                prev = c;
                continue;
            }
            
            if(prev == c)
                prevCnt++;
            else
                anotherCnt++;
            
            if(prevCnt == anotherCnt){
                prevCnt = 0;
                anotherCnt = 0;
                result++;
            }
            
        }
        
        if(prevCnt > 0)
            result++;
        
        return result;
    }
}