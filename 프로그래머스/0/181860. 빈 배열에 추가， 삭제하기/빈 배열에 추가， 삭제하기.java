import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            boolean b = flag[i];
            if(b) list.addAll(Collections.nCopies(arr[i] * 2, arr[i]));
            else list = list.subList(0, list.size() - arr[i]);
        }
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
        
    }
}