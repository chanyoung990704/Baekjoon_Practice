import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        for(int d : delete_list){
            if(list.contains(d)){
                list.remove(findIdx(list, d));
            }
        }
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    int findIdx(List<Integer> l, int target){
        for(int i = 0 ; i < l.size() ; i++)
            if(l.get(i) == target) return i;
        return -1;
    }
}