import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list) {
                
        
        return IntStream.range(0, num_list.length)
            .map(i -> {
                return num_list[num_list.length - 1 - i]; 
            })
            .toArray();
    }
}