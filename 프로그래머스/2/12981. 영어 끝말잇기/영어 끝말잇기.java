import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char prev = '1';
        
        for(int i = 0 ; i < words.length ; i++) {
            boolean isPossible = true;
            // 3번 예외사항
            if(words[i].charAt(0) != prev && i > 0){
                isPossible = false;
            }
            // 4번 예외사항
            if(set.contains(words[i])){
                isPossible = false;
            }
            // 5번 예외사항
            if(words[i].length() <= 1){
                isPossible = false;
            }
            
            if(!isPossible)
                return new int[]{(i % n) + 1, (i / n) + 1};
            
            prev = words[i].charAt(words[i].length() - 1);
            set.add(words[i]);
        }



        return new int[]{0, 0};
    }
}