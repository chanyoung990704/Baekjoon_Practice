class Solution {
    
    public int solution(int n) {
        
        int cnt = 0;
        
        for(int i = 1 ; i <= (int)Math.sqrt(n) ; i++)
            if(n % i == 0){
                cnt++;
                if(n / i != i)
                    cnt++;
            }
        
        return cnt;
    }
}