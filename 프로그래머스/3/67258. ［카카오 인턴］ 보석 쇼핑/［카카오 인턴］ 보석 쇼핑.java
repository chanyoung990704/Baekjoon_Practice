import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] gems) {
        
        // 모든 보석의 개수 확인
        int all = (int)Arrays.stream(gems)
            .distinct()
            .count();

        int[] answer = new int[2];
        int len = Integer.MAX_VALUE;
        
        
        // 투포인터
        int lo = 0;
        int hi = 0;
        
        Map<String, Integer> gemMap = new HashMap<>();
        int cnt = 0;
        
        while(hi < gems.length){
            // 담기
            String cur = gems[hi];
            
            // 처음 담는 것이면 개수 추가
            if(!gemMap.containsKey(cur)){
                cnt++;
            }
            gemMap.put(cur, gemMap.getOrDefault(cur, 0) + 1);
            
            // 모든게 담겼는지 확인
            while(cnt == all){
                // 현재 값 저장 후 
                int curLen = hi - lo + 1;
                if(curLen < len){
                    len = curLen;
                    answer[0] = lo + 1;
                    answer[1] = hi + 1;
                }
                
                // 줄여보기
                String left = gems[lo];
                gemMap.put(left, gemMap.getOrDefault(left, 0) - 1);
                
                if(gemMap.get(left) == 0){
                    gemMap.remove(left);
                    cnt--;
                }
                
                lo++;
            }
            
            hi++;
        }
        
        return answer;
    }
}