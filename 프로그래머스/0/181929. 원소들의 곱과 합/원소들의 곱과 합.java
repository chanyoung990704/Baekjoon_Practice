import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] num_list) {
        
        int mul = Arrays.stream(num_list)
                        .reduce((a, b) -> a * b).orElse(0);
        int sum = Arrays.stream(num_list)
                        .sum();
        if(mul < sum * sum) return 1;
        else return 0;
    }
}