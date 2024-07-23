import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        return LongStream.range(left, right + 1)
            .mapToInt(i -> {
                int y = (int)(i / n);
                int x = (int)(i % n);
                int res = Math.max(y, x) + 1;
                return res;
            })
            .toArray();
        
    }
}