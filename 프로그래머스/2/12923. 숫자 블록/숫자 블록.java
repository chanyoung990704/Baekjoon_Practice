import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        
        int len = (int)(end - begin + 1);
        int[] answer = new int[len];
        Arrays.fill(answer, 1);
        int idx = 0;
        
        while(begin <= end){
            
            if(begin == 1){
                answer[idx] = 0;
            }
            
            for(long i = 2 ; i <= Math.sqrt(begin) ; i++){
                if(begin % i == 0){
                    answer[idx] = Math.max(answer[idx], (int)i);
                    long val = begin / i;
                    if(val <= 10000000){
                        answer[idx] = Math.max(answer[idx], (int) val);
                    }
                }
            }
            
            
            idx++;
            begin++;
        }
        
        return answer;
    }
}