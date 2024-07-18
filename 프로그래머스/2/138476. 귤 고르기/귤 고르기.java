import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tanMap = new HashMap<>();
        for(int t : tangerine)
            tanMap.put(t, tanMap.getOrDefault(t, 0) + 1);
        
        List<Integer> sortedVal = tanMap.values().stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());
        
        int sum = 0;
        int cnt = 0;
        
        for(int c : sortedVal){
            cnt++;
            sum += c;
            if(sum >= k)
                break;
        }
        
        return cnt;
        
    }
}