import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> list = Arrays.stream(citations).boxed()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        
        int h = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        
        return h;
    }
}