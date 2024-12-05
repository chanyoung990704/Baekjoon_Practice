import java.util.*;

class Solution {
    public int[] solution(String myString) {
        List<Integer> ret = new ArrayList<>();
        int cnt = 0;
        
        for(char c : myString.toCharArray()){
            if(c == 'x'){
                ret.add(cnt);
                cnt = 0;
            }else{
                cnt++;
            }
        }

        ret.add(cnt);
        
        return ret.stream().mapToInt(Integer::valueOf).toArray();
    }
}