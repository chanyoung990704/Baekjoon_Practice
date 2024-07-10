import java.util.*;
import java.util.stream.*;

class Solution {
    public long[] solution(int x, int n) {
        
        return LongStream.range(1, n + 1)
            .map(i -> i * x)
            .toArray();
        
    }
}