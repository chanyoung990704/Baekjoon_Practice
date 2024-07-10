import java.util.stream.*;

class Solution {
    public long solution(int price, int money, int count) {
        
        long total = LongStream.range(1, count + 1)
            .map(i -> i * price)
            .sum();
        
        if(money >= total)
            return 0;
        
        return total - money;
    }
}