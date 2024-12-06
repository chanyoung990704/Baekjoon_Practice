import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        while(true){
            List<Integer> op = list.stream().map(i -> {
                if(i >= 50 && i % 2 == 0) return i / 2;
                else if(i < 50 && i % 2 == 1) return i * 2 + 1;
                return i;
            }).collect(Collectors.toList());
            
            if(list.equals(op)) return answer;
            
            list = op;
            answer++;
        }

    }
}