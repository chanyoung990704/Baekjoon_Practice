import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        for(int[] q : queries){
            for(int idx = q[0] ; idx <= q[1] ; idx++)
                if(idx % q[2] == 0) list.set(idx, list.get(idx) + 1);
        }
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}