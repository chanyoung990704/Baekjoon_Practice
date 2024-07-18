import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] elements) {
        List<Integer>list = new ArrayList<>();
        
        int[] elementsX2 = IntStream.concat(Arrays.stream(elements),
                                           Arrays.stream(elements)).toArray();
        
        for(int i = 0 ; i < elements.length ; i++){
            int sum = 0;
            for(int j = i ; j < i + elements.length ; j++){
                sum += elementsX2[j];
                list.add(sum);
            }
        }
        
        return (int)list.stream().mapToInt(Integer::valueOf)
            .distinct().count();
    }
}