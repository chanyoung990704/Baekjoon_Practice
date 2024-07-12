import java.util.*;
import java.util.stream.*;

class Solution {
    
    
    public int getFactors(int n){
        int cnt = 0;
        for(int i = 1 ; i <= (int)Math.sqrt(n) ; i++)
            if(n % i == 0){
                cnt++;
                if(n / i != i)
                    cnt++;
            }
        
        return cnt;
    }
    
    
    public int solution(int number, int limit, int power) {
        return (int)IntStream.range(1, number + 1)
            .map(i -> (getFactors(i) <= limit) ? getFactors(i) : power)
            .sum();
    }
}