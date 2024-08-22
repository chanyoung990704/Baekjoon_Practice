import java.util.*;
import java.util.stream.*;

class Solution {
    int[] dp;
    int[] flatTriangle;
    public int solution(int[][] triangle) {
        int answer = 0;
        flatTriangle = Arrays.stream(triangle)
                             .flatMapToInt(Arrays::stream)
                             .toArray();
        
        int total = (int)Arrays.stream(triangle)
                           .mapToLong(i -> Arrays.stream(i)
                                           .count()
                                     )
                           .sum();
        
        dp = new int[total];
        Arrays.fill(dp, -1);
        
        answer = getValue(0, 1, total);
        return answer;
    }
    
    int getValue(int curIdx, int floor, int maxIdx) {
        if(curIdx >= maxIdx) return 0;
        
        if(dp[curIdx] != -1) return dp[curIdx];
        int ret = 0;
        for(int i = 0 ; i < 2 ; i++) ret = Math.max(ret, getValue(curIdx + floor + i, floor + 1, maxIdx));
        dp[curIdx] = ret + flatTriangle[curIdx];
        return dp[curIdx];
    }
}