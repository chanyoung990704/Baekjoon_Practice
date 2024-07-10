import java.util.*;
import java.util.stream.*;

class Solution {
    public boolean solution(int x) {
        
        int total = Arrays.stream(String.valueOf(x).split(""))
            .mapToInt(Integer::valueOf)
            .sum();
        
        return x % total == 0;
    }
}