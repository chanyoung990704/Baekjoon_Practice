import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[][] score) {
    
        List<Integer> list = Arrays.stream(score)
            .map(s -> s[0] + s[1])
            .collect(Collectors.toList());
        
        return list.stream()
            .map(s -> (int)list.stream()
                     .filter(v -> v > s)
                     .count() + 1)
            .mapToInt(Integer::valueOf)
            .toArray();
        
    }
}