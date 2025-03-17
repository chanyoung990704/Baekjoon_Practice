import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = isPossible(begin, target, words, new boolean[words.length], 0);
        
        return answer == 1000000000 ? 0 : answer;
    }
    
    int isPossible(String cur, String target, String[] words, boolean[] visited, int cnt){
        
        if(cur.equals(target)){
            return cnt;
        }
        
        int min = 1000000000;
        
        // 다음 단어 가능한지
        for(int i = 0 ; i < words.length ; i++){
            String word = words[i];
            int diff = 0;
            for(int j = 0 ; j < word.length() ; j++){
                if(cur.charAt(j) != word.charAt(j)){
                    diff++;
                }
            }
            // 한글자만 차이나야 함
            if(diff == 1 && !visited[i]){
                visited[i] = true;
                min = Math.min(min, isPossible(word, target, words, visited, cnt + 1));
                visited[i] = false;
            }
        }
        
        return min;
    }
}