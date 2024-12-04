import java.util.*;
import java.util.regex.*;

class Solution {
    public String[] solution(String[] strArr) {
        
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile("ad");
        
        for(String str : strArr){
            Matcher m = p.matcher(str);
            if(!m.find()) list.add(str);
        }
        
        return list.stream().toArray(String[]::new);
    }
}