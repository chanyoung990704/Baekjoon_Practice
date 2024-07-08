class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        
        for(var number : numbers)
            answer += number;
        
        answer /= numbers.length;
        
        return answer;
    }
}