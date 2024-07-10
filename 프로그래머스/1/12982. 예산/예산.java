import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int total = 0;
        int cnt = 0;
        
        for(int b : d){
            if(total + b > budget)
                break;
            
            total += b;
            cnt++;
        }
        
        return cnt;
    }
}