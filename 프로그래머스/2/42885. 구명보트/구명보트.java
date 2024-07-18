import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int cnt = 0;
        int lo = 0;
        int hi = people.length - 1;
        
        // 무거운 거 + 가벼운거
        while(lo <= hi) {
            if(people[hi] + people[lo] <= limit){
                hi--;
                lo++;
            }else{
                hi--;
            }
            cnt++;
        }
        
        
        return cnt;
    }
}