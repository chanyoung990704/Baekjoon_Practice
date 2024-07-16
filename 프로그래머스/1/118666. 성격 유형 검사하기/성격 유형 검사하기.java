import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "RTCFJMAN";
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : answer.toCharArray())
            map.put(c, 0);
        
        IntStream.range(0, survey.length)
            .forEach(i -> {
                
                int choice = choices[i];
                char cur = ' ';
                if(choice > 4){
                    cur = survey[i].charAt(1);
                }else{
                    cur = survey[i].charAt(0);
                }
                map.put(cur, map.getOrDefault(cur, 0) + 
                       Math.abs(choice - 4));
            });
        
        
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < answer.length() ; i += 2){
            result.append(
            map.get(answer.charAt(i)) >= map.get(answer.charAt(i + 1)) ?
                answer.charAt(i) : answer.charAt(i + 1)
            );
        }
        
        return result.toString();
    }
}