class Solution {
    int[] stones;
    int k;
    public int solution(int[] stones, int k) {
        this.stones = stones;
        this.k = k;
        
        int answer = 0;
        int lo = 1;
        int hi = 200000000;
        
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(isPossible(mid)){
                // 사람 수 늘리기
                answer = mid;
                lo = mid + 1;
            }else{
                // 사람 수 줄이기
                hi = mid - 1;
            }
        }
        
        
        return answer;
    }
    
    boolean isPossible(int mid){
        int cnt = 0;
        for(int s : stones) {
            // 못건너는 돌의 개수
            if(s - mid < 0) cnt++;
            else cnt = 0;
            
            // 연속 k개 이상이면
            if(cnt >= k) return false;
        }
        return true;
    }
}