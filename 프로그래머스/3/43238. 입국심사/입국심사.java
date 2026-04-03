class Solution {
    public long solution(int n, int[] times) {
        long answer = (long)Math.pow(10,9) * (long) Math.pow(10, 9);
        
        long lo = 1, hi = answer;
        long ans = 0;
        
        while(lo <= hi){
            long mid = (hi -lo)/2 + lo;
            long cnt = 0;
            for(int t : times){
                cnt += mid / t;
            }
            
            if(cnt >= n){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
}