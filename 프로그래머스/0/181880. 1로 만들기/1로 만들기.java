import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int n :num_list) answer += getCnt(n);
        return answer;
    }
    
    int getCnt(int n){
        if(n == 1) return 0;
        
        int cnt = 0;
        if(n % 2 == 0) cnt += getCnt(n / 2) + 1;
        else cnt += getCnt((n - 1) / 2) + 1;
        
        return cnt;
    }
}