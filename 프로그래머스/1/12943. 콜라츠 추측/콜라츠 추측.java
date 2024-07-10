class Solution {
    public int solution(int num) {
        
        long n = (long)num;
        int cnt = 0;
        
        while(n != 1) {
            if(cnt > 500)
                return -1;
            
            cnt++;
            if(n % 2 == 0)
                n /= 2;
            else 
                n = n * 3 + 1;
        }
        
        return cnt;
        
    }
}