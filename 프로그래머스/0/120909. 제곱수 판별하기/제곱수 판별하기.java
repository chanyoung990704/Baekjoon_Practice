
class Solution {
    public int solution(int n) {
        int sqrt = (int)Math.sqrt(n);
        
        if((sqrt * sqrt) == n)
            return 1;
        else
            return 2;
    }
}