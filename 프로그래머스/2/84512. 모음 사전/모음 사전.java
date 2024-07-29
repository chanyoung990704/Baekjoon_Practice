import java.util.*;
import java.util.stream.*;

class Solution {
    
    Map<String, Integer> wordIdx = new HashMap<>();
    String[] words = new String[]{"A", "E", "I", "O", "U"};
    int idx = 1;
    
    public int solution(String word) {
        
        initIdx("");
        return wordIdx.get(word);
    }
    
    
    public void initIdx(String res){
        
        if(res.length() > 0){
            wordIdx.put(res, idx++);
        }
        
        if(res.length() == 5){
            return;
        }
        
        for(int i = 0 ; i < 5 ; i++){
            initIdx(res + words[i]);
        }
        
    }
    
    
}