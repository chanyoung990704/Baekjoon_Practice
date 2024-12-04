import java.util.regex.*;

class Solution {
    public int solution(String my_string, String is_prefix) {
        Pattern p = Pattern.compile("^" + is_prefix + "\\w*");
        Matcher m = p.matcher(my_string);
        
        if(m.find()) return 1;
        else return 0;
        
    }
}