import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        
        List<String> ret = new ArrayList<>();
        
        for(String p : picture){
            StringBuilder sb = new StringBuilder();
            for(char c : p.toCharArray()){
                sb.append(String.valueOf(c).repeat(k));
            }
            for(int i = 0 ; i < k ; i++)
                ret.add(sb.toString());
        }
        
        return ret.toArray(new String[ret.size()]);
    }
}