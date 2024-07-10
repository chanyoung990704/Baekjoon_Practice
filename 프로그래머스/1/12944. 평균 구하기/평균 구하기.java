import java.util.*;

class Solution {
    public double solution(int[] arr) {
        
        return Arrays.stream(arr)
            .mapToDouble(Double::valueOf)
            .average()
            .getAsDouble();
        
    }
}