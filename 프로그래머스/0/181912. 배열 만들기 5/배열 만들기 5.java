import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        
        for(String str : intStrs){
            int val = Integer.valueOf(str.substring(s, s + l));
            if(val > k) answer.add(val);
        }
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}