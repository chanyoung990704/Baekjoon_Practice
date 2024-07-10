import java.util.stream.*;

class Solution {
    public long solution(int a, int b) {
        return LongStream.range(
            (int)Math.min(a, b), (int)Math.max(a, b) + 1)
            .sum();
    }
}