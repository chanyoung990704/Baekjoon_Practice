import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = Arrays.stream(num_list).boxed()
                                        .collect(Collectors.toList());
        return list.subList(n - 1, list.size()).stream()
                    .mapToInt(Integer::valueOf).toArray();
    }
}