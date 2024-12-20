import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        List<Integer> list = Arrays.stream(s.split(" "))
            .map(Integer::valueOf)
            .collect(Collectors.toList());
        
        int min = Collections.min(list);
        int max = Collections.max(list);
        
        String answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}