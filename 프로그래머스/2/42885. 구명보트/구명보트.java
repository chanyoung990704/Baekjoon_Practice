import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int lo = 0;
        int hi = people.length - 1;
        
        int answer = 0;
        
        while(lo <= hi){
            if(lo == hi){
                answer++;
                return answer;
            }
            
            int sum = people[lo] + people[hi];
            // 탑승 불가능
            if(sum > limit){
                hi--;
            }else{
                lo++;
                hi--;
            }
            answer++;
        }
        
        return answer;
    }
}