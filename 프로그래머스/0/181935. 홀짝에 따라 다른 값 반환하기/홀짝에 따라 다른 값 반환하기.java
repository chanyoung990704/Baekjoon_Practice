import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        IntStream is = IntStream.range(1, n + 1);
        
        if(n % 2 == 0){
            return is.filter(i -> i % 2 == 0)
                    .map(i -> i * i)
                    .sum();
        }else{
            return is.filter(i -> i % 2 != 0).sum();
        }
        
    }
}