import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        
        int len = arr.length;
        
        boolean[] b = new boolean[2049];
        for(int i = 1 ; i < 2049 ; i *= 2)
            b[i] = true;
        
        if(b[len]) return arr;
        List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        for(int i = len ; i < 2049 ; i++){
            if(b[i]){
                int size = i - len;
                l.addAll(Collections.nCopies(size, 0));
                return l.stream().mapToInt(Integer::valueOf).toArray();
            }
        }
        
        return new int[]{};
    }
}