class Solution {
    public int solution(int[] numbers, int k) {
        
        int start = 0;
        
        start += (2 * (k - 1));
        
        return (start % numbers.length) + 1;
        
    }
}