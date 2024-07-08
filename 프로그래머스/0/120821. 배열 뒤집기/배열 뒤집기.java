import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;

class Solution {
    public int[] solution(int[] num_list) {
                
        ArrayList<Integer> arr = new ArrayList<>(Arrays.stream(num_list)
                                                    .boxed()
                                                    .collect(Collectors.toList()));
        Collections.reverse(arr);
        
        
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}