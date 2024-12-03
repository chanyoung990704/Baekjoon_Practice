import java.util.regex.*;

class Solution {
    public boolean solution(String s) {
        int len = s.length();
        if (!(len == 4 || len == 6)) return false;
        
        Pattern p = Pattern.compile("\\b\\d+\\b");
        Matcher m = p.matcher(s);
        
        return m.matches();
    }
}