import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(long n) {
        
        String[] arr = String.valueOf(n).split("");
        
        return IntStream.range(0, arr.length)
            .mapToObj(i -> arr[arr.length -1 - i])
            .mapToInt(Integer::valueOf)
            .toArray();
            
            
    }
}