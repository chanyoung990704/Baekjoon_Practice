import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        
        Map<String, Integer> cntMap = new HashMap<>();
        
        Arrays.stream(s.split(""))
            .forEach(i -> cntMap.put(i, cntMap.getOrDefault(i, 0) + 1));
        
        
        return cntMap.entrySet().stream()
            .filter(e -> e.getValue() == 1)
            .map(e -> String.valueOf(e.getKey()))
            .sorted()
            .collect(Collectors.joining());
            
        
        
    }
}