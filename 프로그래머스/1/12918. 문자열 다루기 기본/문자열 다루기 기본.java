import java.util.*;
import java.util.regex.*;
class Solution {
    public boolean solution(String s) {
        
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        
        if(!m.matches())
            return false;
        
        if(!(s.length() == 4 || s.length() == 6))
            return false;
        
        return true;

    }
}