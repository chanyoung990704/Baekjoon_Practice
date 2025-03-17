import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        // target이 없는 경우
        boolean noTarget = true;
        for(String word : words){
            if(word.equals(target)){
                noTarget = false;
                break;
            }
        }
        if(noTarget){
            return 0;
        }
        
        // BFS진행
        Deque<String> dq = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        
        dq.offer(begin);
        map.put(begin, 0);
        
        while(!dq.isEmpty()){
            String cur = dq.pollFirst();
            int cnt = map.get(cur);
            
            if(cur.equals(target)){
                return cnt;
            }
            
            // 다음 단어 변환 가능한지
            for(String word : words){
                if(!map.containsKey(word) && isPossible(cur, word)){
                    dq.offerLast(word);
                    map.put(word, cnt + 1);
                }
            }
        }
        
        return 0;
    }
    
    boolean isPossible(String cur, String word){
        if(cur.length() != word.length()){
            return false;
        }
        int diff = 0;
        for(int i = 0 ; i < cur.length() ; i++){
            if(cur.charAt(i) != word.charAt(i)){
                diff++;
            }
        }
        
        return diff == 1;
    }

}