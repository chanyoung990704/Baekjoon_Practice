import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(long n) {
        
        String s = Arrays.stream(String.valueOf(n).split(""))
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.joining());
        
        return Long.valueOf(s);
        
    }
}