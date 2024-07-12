import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        
        String[] canBabbling = new String[]{"aya", "ye", "woo", "ma"};
        
        int result = 0;
        for(String cur : babbling) {            
            for(String s : canBabbling){
                if(cur.contains(s))
                    cur = cur.replaceFirst(s, " ");
            }
            
            if(cur.trim().isEmpty())
                result++;
        }
        
        
        return result;
    }
}