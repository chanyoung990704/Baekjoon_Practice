class Solution {
    public int solution(int[] array) {
        
        int[] cnt = new int[1001];
        int maxFreq = 0;
        int mode = 0;
        
        for(int n : array) {
            cnt[n]++;
            if(cnt[n] > maxFreq){
                mode = n;
                maxFreq = cnt[n];
            }
        }
        
        
        int modeCnt = 0;
        for(int c : cnt)
            if(c == maxFreq)
                modeCnt++;
        
        return modeCnt > 1 ? -1 : mode;
        
        
    }
}