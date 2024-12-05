import java.util.*;
import java.util.stream.*;

class Solution {
    List<Integer> ret = new ArrayList<>();    
    public int[] solution(int n) {
        
        getAnswer(n);
        return ret.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    void getAnswer(int n){
        ret.add(n);
        if(n == 1) return;
        if(n % 2 == 0) getAnswer(n / 2);
        else getAnswer(3 * n + 1);
    }
}