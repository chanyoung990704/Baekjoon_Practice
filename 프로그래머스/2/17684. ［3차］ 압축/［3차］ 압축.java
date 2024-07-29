import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        // 기본 단어 추가
        List<String> dic = new ArrayList<>();
        for(int i = 0 ; i < 26 ; i++){
            char cur = 'A';
            cur += i;
            dic.add("" + cur);
        }
        
        // 단어 순회
        for(int i = 0 ; i < msg.length(); i++){
        
            String tmp = "" + msg.charAt(i);
            while(i + 1 < msg.length() &&
                 dic.indexOf(tmp + msg.charAt(i + 1)) >= 0){
                tmp = tmp + msg.charAt(i + 1);
                i++;
            }
            
            answer.add(dic.indexOf(tmp) + 1);
            
            if(i < msg.length() - 1){
                String next =tmp + msg.charAt(i + 1);
                if(!dic.contains(next))
                    dic.add(next);
            }
            
        }
        
        
        return answer.stream().mapToInt(Integer::valueOf)
            .toArray();
    }
}