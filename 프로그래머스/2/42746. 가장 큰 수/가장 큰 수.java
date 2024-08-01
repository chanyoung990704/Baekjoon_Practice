import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers)
            .boxed()
            .map(String::valueOf)
            .sorted((a, b) -> (b + a).compareTo(a + b))
            .toArray(String[]::new);
        
        if (nums[0].equals("0")) {
            return "0";
        }
        
        return Arrays.stream(nums)
            .collect(Collectors.joining());
    }
}