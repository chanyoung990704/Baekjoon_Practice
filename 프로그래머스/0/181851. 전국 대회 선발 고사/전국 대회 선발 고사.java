import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<Integer> list = IntStream.range(0, rank.length)
            .filter(i -> attendance[i])
            .boxed()
            .sorted(Comparator.comparing(i -> rank[i]))
            .collect(Collectors.toList());
        

        return list.get(0) * 10000 + list.get(1) * 100 + list.get(2);
    }
}