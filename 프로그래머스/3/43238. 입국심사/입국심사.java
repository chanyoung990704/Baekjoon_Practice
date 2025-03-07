class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long sum = 0;
        for(int i = 0 ; i < times.length ; i++){
            sum += times[i];
        }
        
        long lo = 1;
        long hi = sum / times.length * n;
        
        while(lo <= hi){
            long mid = (hi - lo) / 2 + lo;
            long fin = totalFin(mid, times);
            
            // 통과 케이스
            if(fin >= n){
                answer = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        
        return answer;
    }
    
    
    long totalFin(long mid, int[] times){
        long total = 0;
        for(int i = 0 ; i < times.length ; i++){
            total += mid / (long) times[i];   
        }
        return total;
    }
}