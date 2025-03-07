import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int n = progresses.length;
        
        // 배포 가능 시간으로 변경
        int[] time = IntStream.range(0, n)
            .map(i -> {
                int remain = 100 - progresses[i];
                int s = speeds[i];
                return (remain + s - 1) / s;
            }).toArray();
        
        // 로직
        for(int i = 0 ; i < n ; i++){
            // 배포 가능
            if(!dq.isEmpty() && dq.peekFirst() < time[i]){
                res.add(dq.size());
                while(!dq.isEmpty()){
                    dq.poll();
                }
            }
            dq.offerLast(time[i]);
        }
        
        if(!dq.isEmpty()){
            res.add(dq.size());
        }
        
        
        return res.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}