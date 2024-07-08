import java.util.Arrays;

class Solution {
    public int solution(int[] box, int n) {
        
        return Arrays.stream(box)
            .map(i -> i / n)
            .reduce(1, (a, b) -> a * b);
                
    }
}