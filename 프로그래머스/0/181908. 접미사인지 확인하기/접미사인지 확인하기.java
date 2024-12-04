import java.util.regex.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        Pattern p = Pattern.compile(is_suffix + "$");
        Matcher m = p.matcher(my_string);
    
        if(m.find()) return 1;
        else return 0;

    }
}