import java.util.*;

class Solution {
    int len;
    String message;
    int[][] spoiler_ranges;
    int answer = 0;
    
    public int solution(String message, int[][] spoiler_ranges) {
        this.message = message; this.spoiler_ranges = spoiler_ranges; len = message.length();
        
        // 스포일러 영역이 아닌 단어 집합
        Set<String> words = new HashSet<>();
        
        boolean[] spoiled = new boolean[len];
        for(int[] range : spoiler_ranges){
            int s = range[0], e = range[1];
            for(int i = s ; i <= e; i++){
                spoiled[i] = true;
            }
        }
        
        int startIdx = 0;
        while (startIdx < len) {
            if (message.charAt(startIdx) == ' ') {
                startIdx++;
                continue;
            }
            
            int endIdx = startIdx;
            boolean isSpoiledWord = false;
            
            while (endIdx < len && message.charAt(endIdx) != ' ') {
                if (spoiled[endIdx]) {
                    isSpoiledWord = true;
                }
                endIdx++;
            }
            
            if (!isSpoiledWord) {
                words.add(message.substring(startIdx, endIdx));
            }
            
            startIdx = endIdx;
        }

        Set<String> previous = new HashSet<>();
        for(int[] range: spoiler_ranges){
            int[] idx = extendIdx(range[0], range[1]);
            String sub = message.substring(idx[0], idx[1]);
            
            for(String str : sub.trim().split("\\s+")){
                if(str.isEmpty()){
                    continue;
                }
                if(!words.contains(str) && !previous.contains(str)){
                    answer++;
                }
                previous.add(str);
            }
        }
        
        return answer;
    }
    
    int[] extendIdx(int left, int right){
        // 왼쪽
        while(left > 0 && message.charAt(left-1) != ' '){
            left--;
        }
        // 오른쪽
        while(right < len && message.charAt(right) != ' '){
            right++;
        }
        
        return new int[]{left, right};
    }
}