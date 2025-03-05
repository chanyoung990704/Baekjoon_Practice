import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, List<String[]>> map = 
            Arrays.stream(clothes)
            .collect(Collectors.groupingBy((String[] i) -> i[1]));
        
        int val = map.entrySet()
            .stream()
            .map(Map.Entry::getValue)
            .map(i -> i.size() + 1)
            .reduce(1, (a, b) -> a * b);
        
        return val - 1;
    }
}