import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> ret = new ArrayList<>();
        for(int i = 0 ; i < my_string.length() ; i++){
            ret.add(my_string.substring(i, my_string.length()));
        }
        
        return ret.stream().sorted().toArray(String[]::new);
    }
}