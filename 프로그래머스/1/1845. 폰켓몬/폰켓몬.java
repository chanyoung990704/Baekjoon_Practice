import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> set = 
            Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet());
        
        int max = nums.length / 2;
        
        return set.size() >= max ? max : set.size();
    }
}