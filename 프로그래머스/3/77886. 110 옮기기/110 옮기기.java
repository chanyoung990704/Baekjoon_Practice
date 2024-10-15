import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] s) {
        List<String> result = new ArrayList<>();
        for(String cur : s) result.add(convertString(cur));
        return result.stream()
                     .toArray(String[]::new);
    }
    
    String convertString(String cur){
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        // 110 뽑아내기
        for(char c : cur.toCharArray()){
            sb.append(c);
            if(sb.length() >= 3 && sb.substring(sb.length() - 3).equals("110")){
                cnt++;
                sb.setLength(sb.length() - 3);
            }
        }
        
        // idx 찾기
        int idx = sb.length();
        while(idx > 0 && sb.charAt(idx - 1) == '1') idx--;
        
        sb.insert(idx, "110".repeat(cnt));
        
        return sb.toString();
    }
}