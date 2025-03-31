import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        // 이분탐색
        
        int lo = 1;
        int hi = 200000000;
        
        while(lo <= hi){
            // 건널 수 있는 친구 수
            int mid = lo + (hi - lo) / 2;
            
            // 가능하면
            if(getCnt(stones, mid, k)){
                answer = mid;
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        
        return answer;
    }
    
    boolean getCnt(int[] stones, int m, int k){
        
        int consecutive = 0;
        
        for(int i = 0 ; i < stones.length ; i++){
            int s = stones[i];
            // 0개 이하가 연속 k개 발생하면
            if(consecutive >= k){
                return false;
            }
            
            if(s - m < 0){
                consecutive++;
            }else{
                consecutive = 0;
            }
        }
        
        if(consecutive >= k){
            return false;
        }
        
        return true;
    }
}