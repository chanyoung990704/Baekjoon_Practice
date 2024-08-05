import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Long> dq1 = Arrays.stream(queue1)
            .mapToObj(Long::valueOf)
            .collect(Collectors.toCollection(ArrayDeque::new));
        
        Deque<Long> dq2 = Arrays.stream(queue2)
            .mapToObj(Long::valueOf)
            .collect(Collectors.toCollection(ArrayDeque::new));
        
        long dq1Sum = dq1.stream().mapToLong(Long::valueOf).sum();
        long dq2Sum = dq2.stream().mapToLong(Long::valueOf).sum();
        long totalSum = dq1Sum + dq2Sum;
        
        // 홀수이면 제외
        if(totalSum % 2 == 1){
            return -1;
        }
        
        long target = totalSum / 2;
        int limit = (dq1.size() + dq2.size()) * 2;
        int cnt = 0;
        
        while(dq1Sum != target){
            if(cnt >= limit){
                return -1;
            }
            
            if(dq1Sum > target){  // 수정된 부분
                long value = dq1.pollFirst();
                dq1Sum -= value;
                dq2Sum += value;
                dq2.offerLast(value);
            }else{
                long value = dq2.pollFirst();
                dq1Sum += value;
                dq2Sum -= value;
                dq1.offerLast(value);
            }
            cnt++;
        }
        
        return cnt;
    }
}