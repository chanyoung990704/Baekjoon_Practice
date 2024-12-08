import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for(int[] q: queries){
            List<Integer> subList = list.subList(q[0], q[1] + 1)
                .stream().filter(i -> i > q[2]).sorted()
                .collect(Collectors.toList());
            if(subList.isEmpty()) result.add(-1);
            else result.add(subList.get(0));
        }
        
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}