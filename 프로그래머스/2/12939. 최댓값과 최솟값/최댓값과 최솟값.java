import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        int min = Arrays.stream(s.split(" "))
            .mapToInt(Integer::valueOf)
            .min().getAsInt();
        
        int max = Arrays.stream(s.split(" "))
            .mapToInt(Integer::valueOf)
            .max().getAsInt();        
        
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
    }
}