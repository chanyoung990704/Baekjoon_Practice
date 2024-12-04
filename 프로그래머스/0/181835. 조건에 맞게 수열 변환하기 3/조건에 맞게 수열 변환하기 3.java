import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        if(k % 2 == 0){
            return list.stream().map(i -> i + k)
                        .mapToInt(Integer::valueOf).toArray();
        }
        else{
            return list.stream().map(i -> i * k)
                .mapToInt(Integer::valueOf).toArray();
        }
        
    }
}