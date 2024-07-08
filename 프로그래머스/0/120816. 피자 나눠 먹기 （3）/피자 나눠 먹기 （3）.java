class Solution {
    public int solution(int slice, int n) {
        
        int answer = n / slice;
        
        n %= slice;
        
        
        if(n > 0)
            answer++;
        
        return answer;
    }
}