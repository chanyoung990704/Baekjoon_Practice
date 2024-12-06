import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(list);
        
        if(!set.contains(2)) return new int[]{-1};
        
        int lo = 0;
        int hi = 0;
        
        for(int i = 0 ; i < list.size() ; i++)
            if(list.get(i) == 2){
                lo = i;
                break;
            }
        
        for(int j = list.size() - 1 ; j >= 0 ; j--)
            if(list.get(j) == 2){
                hi = j;
                break;
            }
        
        return list.subList(lo, hi + 1).stream()
                    .mapToInt(Integer::valueOf).toArray();
    }
}