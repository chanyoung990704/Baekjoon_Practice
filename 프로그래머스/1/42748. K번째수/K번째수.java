import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> ret = new ArrayList<>();
        for(int[] c : commands){
            List<Integer> sub = new ArrayList<>(list.subList(c[0] - 1, c[1]));
            Collections.sort(sub, Comparator.naturalOrder());
            ret.add(sub.get(c[2] - 1));
        }
        
        return ret.stream().mapToInt(Integer::valueOf).toArray();
    }
}