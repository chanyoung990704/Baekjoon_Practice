class Solution {
    
    String isOne = "11011";
    
    public int solution(int n, long l, long r) {
        return getOneCnt(n, l - 1, r - 1);
    }
    
    int getOneCnt(int n, long l, long r){
        if(n == 0) return 1;
        
        int cnt = 0;
        long prevLen = (long)Math.pow(5, n - 1);
        
        for(long i = l ; i <= r ;){
            int section = (int)(i / prevLen);
            long start = prevLen * section;
            long end = start + prevLen - 1;
            
            if(isOne.charAt(section) == '1'){
                if(i <= start && r >= end){
                    cnt += allSection(n - 1);
                    i = end + 1;
                }else{
                    cnt += getOneCnt(n - 1, i - start, Math.min(r - start, prevLen - 1));
                    i = Math.min(end + 1, r + 1);
                }
            }else{
                i = Math.min(end + 1, r + 1);
            }
        }
        
        return cnt;
    }
    
    int allSection(int n){
        if(n == 0) return 1;
        return 4 * allSection(n - 1);
    }
}