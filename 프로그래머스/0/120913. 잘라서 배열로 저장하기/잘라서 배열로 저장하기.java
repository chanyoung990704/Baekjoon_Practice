import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String my_str, int n) {
        
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(my_str);
        
        int idx = 0;
        
        while(idx < my_str.length()) {
            list.add(sb.substring(idx, Math.min(my_str.length(), idx + n)));
            idx += n;
        }
        
        
        
        return list.toArray(String[]::new);
    }
}