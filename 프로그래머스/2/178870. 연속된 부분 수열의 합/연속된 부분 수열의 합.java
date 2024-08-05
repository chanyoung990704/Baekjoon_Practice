class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 0};
        
        int lo = 0;
        int hi = 0;
        
        int total = 0;
        int len = Integer.MAX_VALUE;
        while(hi < sequence.length) {
            total += sequence[hi];
            
            while(lo <= hi && total > k){
                total -= sequence[lo++];
            }
            
            if(total == k){
                if(hi - lo < len){
                    len = hi - lo;
                    answer[0] = lo;
                    answer[1] = hi;
                }
            }
            hi++;
        }
        
        return answer;
    }
}