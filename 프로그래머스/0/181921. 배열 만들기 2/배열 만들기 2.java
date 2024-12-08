import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> res = new ArrayList<>();
        
        Pattern p = Pattern.compile("^[05]+$");
        for(int i = l ; i <= r ; i++){
            
            String str = String.valueOf(i);
            Matcher m = p.matcher(str);
            if(m.find()) res.add(i);
            
        }
        
        if(res.isEmpty()) res.add(-1);
        
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}