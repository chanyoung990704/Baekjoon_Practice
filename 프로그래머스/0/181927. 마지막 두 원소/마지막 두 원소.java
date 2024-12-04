import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list).boxed()
                                                    .collect(Collectors.toList());
        int len = list.size();
        if(list.get(len - 1) > list.get(len - 2)) list.add(list.get(len - 1) - list.get(len - 2));
        else list.add(list.get(len - 1) * 2);
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}