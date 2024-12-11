import java.util.*;
import java.util.stream.*;

class Solution {
    int[] diffs, times;
    long limit;
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int lo = 1;
        int hi = 100000;
        
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        
        while(lo <= hi) {
            
            int mid = (lo + hi) / 2;
            long val = getVal(mid);
            
            if(val > limit){
                lo = mid + 1;
            }else{
                answer = mid;
                hi = mid - 1;
            }
        }
        
        return answer;
    }
    
    long getVal(int level){
        int len = diffs.length;
        long t = times[0];
        
        for(int i = 1 ; i < len ; i++) {
            int diff = diffs[i];
            int time_prev = times[i - 1];
            int time_cur = times[i];
            
            if(level >= diffs[i]) t += time_cur;
            else{
                int cnt = Math.abs(diff - level);
                long addVal = cnt * (time_prev + time_cur) + time_cur;
                t += addVal;
            }
        }
        
        return t;
    }
}