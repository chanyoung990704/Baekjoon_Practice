import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int lo = 1, hi = (int)Math.pow(10, 9);
        int answer = 0;
        
        // 정렬
        Arrays.sort(rocks);
        
        while(lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            // mid가 거리 최솟값
            int del = 0;
            int prev = 0;
            for(int i = 0 ; i < rocks.length ; i++){
                int cur = rocks[i];
                // 거리가 최솟값보다 작으면 
                if(cur - prev < mid){
                    del++;
                    continue;
                }
                prev = cur;
            }
            // 마지막 확인
            if(distance - prev < mid){
                del++;
            }
            
            if(del<=n){
                answer = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        
        return answer;
    }
}