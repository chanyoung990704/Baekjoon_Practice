import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 사람 몸무게 people
        // 구명보트 무게제한 limit
        
        // 정렬
        Arrays.sort(people);
        
        // 투포인터
        int lo = 0;
        int hi = people.length - 1;
        int answer = 0;
        
        while(lo <= hi){
            
            // 겹치는 경우
            if(lo == hi){
                answer++;
                break;
            }
            
            // 합계
            int sum = people[lo] + people[hi];
            
            // 합계가 초과하면 한명만 탈출
            if(sum > limit){
                hi--;
            }
            // 2명 가능
            else{
                lo++;
                hi--;
            }
            // 개수 증가
            answer++;
            
        }
        
        return answer;
    }
}