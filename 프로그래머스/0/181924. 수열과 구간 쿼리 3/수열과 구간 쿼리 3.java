import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for(int[] q : queries) swap(list, q[0], q[1]);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    void swap(List<Integer> arr, int i, int j){
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
}