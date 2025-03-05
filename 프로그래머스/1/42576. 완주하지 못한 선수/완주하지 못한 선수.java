import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = Arrays.stream(completion)
            .collect(Collectors.toMap(String::valueOf, (s) -> 1, (o, n) -> o + n));
        
        String answer = Arrays.stream(participant)
            .filter(i -> {
                if(!map.containsKey(i)){
                    return true;
                }
                int v = map.get(i);
                if(v - 1 == 0){
                    map.remove(i);
                }else{
                    map.put(i, v - 1);
                }
                return false;
            })
            .findFirst().get();
            
        return answer;
    }
}