import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for(int[] q : queries) addPlusOne(list, q[0], q[1]);
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    void addPlusOne(List<Integer> list, int i, int j){
        for(int idx = i ; idx <= j ; idx++)
            list.set(idx, list.get(idx)+1);
    }
}