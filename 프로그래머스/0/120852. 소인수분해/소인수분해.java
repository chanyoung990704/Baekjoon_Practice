import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;


class Solution {
    
    public boolean[] get_primes(int n) {
        
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        
        primes[0] = false;  primes[1] = false;
        
        for(int i = 2; i <= (int)Math.sqrt(n) ; i++) {
            if(primes[i])
                for(int j = i * i ; j <= n ; j += i)
                    primes[j] = false;
        }
        
        
        return primes;
    }
    
    public int[] solution(int n) {
        
        Set<Integer> set = new HashSet<>();
        boolean[] primes = get_primes(n);
        
        for(int i = 2 ; i <= n ; i++)
            if(primes[i] && n % i == 0)
                set.add(i);
        
        return set.stream()
            .sorted()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}