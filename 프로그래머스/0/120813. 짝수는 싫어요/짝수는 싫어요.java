import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n) {
        int[] answer =  IntStream.range(1, n + 1).filter(cur -> cur % 2 != 0)
            .toArray();
        
        Arrays.sort(answer);
        
        return answer;
    }
}