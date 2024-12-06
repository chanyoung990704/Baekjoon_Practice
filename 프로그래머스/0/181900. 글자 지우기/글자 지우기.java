import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        
        StringBuilder sb = new StringBuilder();
        
        Set<Integer> s = Arrays.stream(indices).boxed().collect(Collectors.toSet());
        
        for(int i = 0 ; i < my_string.length() ; i++)
            if(!s.contains(i)) sb.append(my_string.charAt(i));
        
        
        return sb.toString();
    }
}