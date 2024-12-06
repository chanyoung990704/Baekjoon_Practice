import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String myStr) {
        if(myStr.replaceAll("[abc]+", "").equals(""))
            return new String[]{"EMPTY"};
        
        List<String> ret = new ArrayList<>();
        String[] strs = myStr.replaceAll("[abc]+", " ").split(" ");
        for(String str : strs)
            if(!str.equals("")) ret.add(str);
        
        return ret.stream().toArray(String[]::new);
    }
}