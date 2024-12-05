import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        List<Integer> ret = new ArrayList<>();
        for(int[] interval : intervals){
            ret.addAll(list.subList(interval[0], interval[1] + 1));
        }
        
        return ret.stream().mapToInt(Integer::valueOf).toArray();
    }
}