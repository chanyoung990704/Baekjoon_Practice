import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] num_list) {
        List<Integer> answer = IntStream.range(0, num_list.length)
                                    .filter(i -> num_list[i] < 0)
                                    .boxed().collect(Collectors.toList());
        if(answer.size() == 0) return -1;
        else return answer.get(0);
    }
}