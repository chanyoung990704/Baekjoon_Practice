import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> sortedList = Arrays.stream(num_list).sorted()
                                        .boxed()
                                        .collect(Collectors.toList());
        sortedList = sortedList.subList(0, 5);
        return sortedList.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}