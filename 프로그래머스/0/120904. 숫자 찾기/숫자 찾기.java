class Solution {
    public int solution(int num, int k) {
        int ret =  (int)String.valueOf(num).indexOf(String.valueOf(k));
        
        if(ret == -1)
            return ret;
        else
            return ret + 1;
    }
}