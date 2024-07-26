import java.util.*;
import java.util.stream.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = Arrays.stream(phone_book)
            .collect(Collectors.toSet());
        
        for(String p : phone_book){
            for(int i = 1 ; i < p.length() ; i++){
                String prefix = p.substring(0, i);
                if(set.contains(prefix)){
                    return false;
                }
            }
        }
        
        return answer;
    }
}