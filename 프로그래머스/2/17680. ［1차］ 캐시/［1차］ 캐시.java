import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        Deque<String> dq = new ArrayDeque<>();
        
        for(String city : cities) {
            city = city.toLowerCase();
            
            // 캐시에 있는 경우
            if(dq.remove(city)){
                answer += 1; 
                dq.addLast(city); 
            } else {                
                // 캐시가 가득 찬 경우
                if(dq.size() >= cacheSize){
                    dq.removeFirst();
                }
                answer += 5;
                dq.addLast(city);
            }
        }
        
        return answer;
    }
}