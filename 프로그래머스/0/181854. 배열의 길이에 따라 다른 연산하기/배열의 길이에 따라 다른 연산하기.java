import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int n) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        if(list.size() % 2 == 0){
            return IntStream.range(0, arr.length)
                            .map(i -> {
                                if(i % 2 == 1) return arr[i] + n;
                                return arr[i];
                            }).toArray();
        }else{
            return IntStream.range(0, arr.length)
                            .map(i -> {
                                if(i % 2 == 0) return arr[i] + n;
                                return arr[i];
                            }).toArray();            
        }
        
    }
}