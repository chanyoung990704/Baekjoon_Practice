import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        int i = 0;
        while(i < arr.length){
            if(list.isEmpty()){
                list.add(arr[i++]);
            }
            else if(list.get(list.size() - 1) < arr[i]){
                list.add(arr[i++]);
            }else if(list.get(list.size() - 1) >= arr[i]){
                list.remove(list.size() - 1);
            }
        }
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}