import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int start_num, int end_num) {
        return IntStream.range(end_num, start_num + 1)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}