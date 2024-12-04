import java.util.*;
class Solution {
    public int solution(int n, String control) {
        Map<Character, Integer> wordVal = new HashMap<>();
        Map<Character, Integer> wordCnt = new HashMap<>();
        
        wordVal.put('w', 1);
        wordVal.put('s', -1);
        wordVal.put('d', 10);
        wordVal.put('a', -10);
        
        for(char c : control.toCharArray())
            wordCnt.put(c, wordCnt.getOrDefault(c, 0) + 1);
        
        for(Map.Entry<Character, Integer> e : wordCnt.entrySet()){
            char c = e.getKey();
            int val = e.getValue();
            
            n += (wordVal.get(c) * val);
        }
        
        return n;
    }
}