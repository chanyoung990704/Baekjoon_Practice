import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        
        Deque<Integer> dq = new ArrayDeque<>(Arrays.stream(num_list).boxed()
                                                    .collect(Collectors.toList())
                                            );
        for(int i = 0 ; i < n ; i++) dq.offerLast(dq.pollFirst());
        return dq.stream().mapToInt(Integer::valueOf).toArray();
    }
}