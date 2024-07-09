import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        return Arrays.stream(array)
            .boxed()
            .sorted((a, b) -> {
                int diffA = Math.abs(a - n);
                int diffB = Math.abs(b - n);
                if (diffA == diffB) {
                    return a.compareTo(b);  // 차이가 같을 경우 작은 수를 먼저
                }
                return Integer.compare(diffA, diffB);
            })
            .findFirst()
            .orElse(0);
    }
}
