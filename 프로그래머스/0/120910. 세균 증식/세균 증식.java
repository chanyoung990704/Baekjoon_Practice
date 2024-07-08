class Solution {
    public int solution(int n, int t) {
        
        int cnt = 1;
        
        while(cnt <= t){
            n *= 2;
            cnt++;
        }
        
        return n;
    }
}