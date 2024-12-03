import java.util.regex.*;
import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String my_string) {
        
        Pattern p = Pattern.compile("\\b[\\w\\d]+\\b");
        Matcher m = p.matcher(my_string);
        
        List<String> answer = new ArrayList<>();
        while(m.find()){
            answer.add(m.group());
        }
    
        return answer.stream().toArray(String[]::new);
    }
}