class Solution {
    public int[] solution(long begin, long end) {
        
        int len = (int)(end - begin) + 1;
        
        int[] answer = new int[len];
        
        for(long i = begin ; i <= end ; i++){
            int idx = (int)(i - begin);
            answer[idx] = getVal(i);
        }
        
        return answer;
    }
    
    
    int getVal(long n){
        
        if(n == 1) return 0;
        
        int ret = 1;
        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                if(i <= 10000000)
                    ret = Math.max(ret, i);
                if(n / i <= 10000000)
                    ret = Math.max(ret, (int)n / i);
            }
        }
        
        return ret;
    }
}