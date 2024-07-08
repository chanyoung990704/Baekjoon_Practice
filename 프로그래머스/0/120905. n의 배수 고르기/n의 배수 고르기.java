import java.util.stream.IntStream;
import java.util.Arrays;


class Solution {
    public int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist)
            .filter(c -> c % n == 0)
            .toArray();
    }
}