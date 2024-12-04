import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int n : arr){
            list.addAll(Collections.nCopies(n,n));
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}