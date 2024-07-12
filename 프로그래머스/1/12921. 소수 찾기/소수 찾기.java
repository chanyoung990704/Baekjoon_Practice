import java.util.*;
import java.util.stream.*;

class Solution {
    
    public boolean[] getPrimeArr(int n){
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        
        for(int i = 2 ; i <= (int)Math.sqrt(n) ; i++)
            if(isPrime[i])
                for(int j = i * i ; j <= n ; j += i)
                    isPrime[j] = false;
        
        return isPrime;
        
    }
    
    
    public int solution(int n) {
        boolean[] isPrime = getPrimeArr(n);
        return (int)IntStream.range(1, n + 1)
            .filter(i -> isPrime[i])
            .count();
        
    }
}