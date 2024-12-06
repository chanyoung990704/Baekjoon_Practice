import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int n) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            List<Integer> l = new ArrayList<>(Collections.nCopies(n, 0));
            l.set(i, 1);
            list.add(l);
        }
        
        return list.stream()
                    .map(i -> i.stream().mapToInt(Integer::valueOf)
                                .toArray())
                    .toArray(int[][]::new);
    }
}