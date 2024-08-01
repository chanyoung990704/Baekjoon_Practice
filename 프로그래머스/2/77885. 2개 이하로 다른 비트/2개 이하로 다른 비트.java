import java.util.stream.*;
import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        List<Long> answer = new ArrayList<>();
        
        for(long n : numbers) {
            
            // 짝수일 때, 홀수일 때
            if(n % 2 == 0){
                answer.add(n + 1);
            }else{
                long bit = 1;
                while((n & bit) != 0) {
                    bit <<= 1;
                }
                answer.add(n + bit / 2);
            }
            
        }
        
        return answer.stream().
            mapToLong(Long::valueOf)
            .toArray();
    }
}