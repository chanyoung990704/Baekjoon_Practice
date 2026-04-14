import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        
        long lo = 1;
        long hi = (long)1e15;
        
        while(lo <= hi){
            long mid = (hi - lo) / 2 + lo;
            
            if(isPossible(mid,a,b,g,s,w,t)){
                answer = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        
        return answer;
    }
    
    public boolean isPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long totalG = 0, totalS = 0, totalCombined = 0;
        for (int i = 0; i < g.length; i++) {
            long cnt = (time + t[i]) / (2L * t[i]);
            long maxW = cnt * w[i];

            totalG += Math.min(g[i], maxW);
            totalS += Math.min(s[i], maxW);
            totalCombined += Math.min(g[i] + s[i], maxW);
        }
        return totalG >= a && totalS >= b && totalCombined >= (long)a + b;
    }
    
   
}