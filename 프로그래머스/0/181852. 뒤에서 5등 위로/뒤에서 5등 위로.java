import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list).boxed().sorted()
                                    .collect(Collectors.toList());
        return list.subList(5, list.size())
                    .stream().mapToInt(Integer::valueOf).toArray();
    }
}