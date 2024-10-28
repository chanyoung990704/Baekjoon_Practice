import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        long cnt = map.entrySet().stream()
                                 .map(i -> i.getKey())
                                 .count();
        
        int answer = (int)cnt;
        if(cnt >= nums.length / 2) return nums.length / 2;
        return answer;
    }
}