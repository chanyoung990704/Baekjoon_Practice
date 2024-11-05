class Solution {
    public int solution(int n, int[] cores) {
        
        if(n <= cores.length) return n;
        
        int lo = 1;
        int hi = 10000 * n;
        int ret = 0;
        
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            long cnt = getCnt(mid, cores);
            if(cnt >= n){
                ret = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        long work = getCnt(ret - 1, cores);
        for(int i = 0 ; i < cores.length ; i++){
            if(ret % cores[i] == 0) work++;
            if(work == n) return i + 1;
        }
        
        return -1;
    }
    
    long getCnt(int time, int[] cores){
        long cnt = cores.length;
        
        for(int core : cores) cnt += time / core;
        return cnt;
    }
}