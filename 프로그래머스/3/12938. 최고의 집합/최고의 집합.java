import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int s) {
        
        // 안되는 경우
        if(s < n){
            return new int[]{-1};
        }
        
        int[] res = new int[n];
        
        // 몫
        for(int i = 0 ; i < n ; i++){
            res[i] = s / n;
        }
        
        // 나머지
        int remain = s % n;
        
        // 뒤에서부터 1씩 증가
        int idx = n - 1;
        while(remain > 0){
            res[idx]++;
            remain--;
            idx--;
            if(idx < 0){
                idx = n - 1;
            }
        }
        
        return res;
    }
}