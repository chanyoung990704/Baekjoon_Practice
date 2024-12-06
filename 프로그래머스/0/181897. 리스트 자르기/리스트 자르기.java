import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        
        switch(n){
            case 1:
                return list.subList(0, slicer[1] + 1).stream()
                    .mapToInt(Integer::valueOf).toArray();
                
            case 2:
                return list.subList(slicer[0], list.size()).stream()
                    .mapToInt(Integer::valueOf).toArray();
            
            case 3:
                return list.subList(slicer[0], slicer[1] + 1).stream()
                    .mapToInt(Integer::valueOf).toArray();
            
            case 4:
                List<Integer> ret = new ArrayList<>();
                for(int i = slicer[0] ; i <= slicer[1] ; i += slicer[2])
                    ret.add(list.get(i));
                return ret.stream().mapToInt(Integer::valueOf).toArray();
            
            default:
                return new int[]{};
        }
    }
}