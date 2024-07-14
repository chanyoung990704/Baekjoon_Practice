import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String p : participant)
            map.put(p, map.getOrDefault(p, 0) + 1);
        
        for(String c : completion){
            int renewCnt = map.get(c) - 1;
            if(renewCnt == 0)
                map.remove(c);
            else
                map.put(c, renewCnt);
        }
        
        String answer = "";
        
        for(Map.Entry<String, Integer> s : map.entrySet()){
           answer = s.getKey(); 
        }
        
        return answer;
    }
}