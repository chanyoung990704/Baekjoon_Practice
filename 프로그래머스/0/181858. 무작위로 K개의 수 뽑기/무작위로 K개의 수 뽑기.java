import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        
        List<Integer> list = Arrays.stream(arr).distinct()
                                    .boxed()
                                    .collect(Collectors.toList());
        int len = list.size();
        if(list.size() >= k) list = list.subList(0, k);
        else{
            for(int i = 0 ; i < Math.abs(len - k) ; i++) list.add(-1);
        }
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}