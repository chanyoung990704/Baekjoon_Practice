import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int total = Arrays.stream(numbers).sum();
        
        return 45 - total;
    }
}