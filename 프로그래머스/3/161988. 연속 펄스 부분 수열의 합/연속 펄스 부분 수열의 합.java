import java.util.*;

class Solution {
    int[] sequence;
    
    public long solution(int[] sequence) {
        this.sequence = sequence;
        long answer = Math.max(getMaxSum(1), getMaxSum(-1));
        return answer;
    }
    
    long getMaxSum(int pulse){
        long total = 0;
        long segment = 0;
        
        for(int i = 0 ; i < sequence.length ; i++) {
            int cur = sequence[i] * pulse;
            segment = Math.max(segment + cur, cur);
            total = Math.max(total, segment);
            pulse *= -1;
        }
        
        return total;
    }
}