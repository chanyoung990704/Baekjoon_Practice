import java.util.stream.IntStream;

class Solution {
    
    public int get_cnt(int n) {
        int cnt = 0;
        
        for(int i = 1 ; i <= (int)Math.sqrt(n) ; i++)
            if(n % i == 0){
                cnt++;
                if(n / i != i)
                    cnt++;
            }
        
        return cnt;
    }
    
    public int solution(int n) {
        
        return (int)IntStream.range(1, n + 1)
            .filter(i -> get_cnt(i) >= 3)
            .count();
        
    }
}