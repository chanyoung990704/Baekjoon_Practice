import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s, String skip, int index) {
        
        List<Character> list = new ArrayList<>();
        Set<Character> set = skip.chars().mapToObj(ch -> (char)ch)
            .collect(Collectors.toSet());
        
        for(int i = 0 ; i < 26 ; i++){
            char cur = (char)('a' + i);
            if(!set.contains(cur))
                list.add(cur);
        }
        
        return s.chars().mapToObj(ch -> (char)ch)
            .map(ch -> list.get((list.indexOf(ch) + index) % list.size()))
            .map(String::valueOf)
            .collect(Collectors.joining());
    }
}