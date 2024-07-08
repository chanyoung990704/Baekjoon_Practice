import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        
        Arrays.sort(numbers);
        
        int positive = numbers[numbers.length - 1] *
            numbers[numbers.length - 2];
        
        int negative = numbers[0] * numbers[1];

        
        return Math.max(positive, negative);
    }
}