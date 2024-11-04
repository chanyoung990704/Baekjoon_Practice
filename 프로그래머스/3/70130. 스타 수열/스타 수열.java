import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] a) {
        if (a.length < 2) return 0;
        
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : a) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        int maxLength = 0;
        
        for (int x : frequency.keySet()) {
            if (frequency.get(x) * 2 <= maxLength) continue;
            
            int length = 0;
            
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] == a[i + 1]) continue;
                
                if (a[i] == x || a[i + 1] == x) {
                    length += 2;
                    i++; 
                }
            }
            
            maxLength = Math.max(maxLength, length);
        }
        
        return maxLength;
    }
}