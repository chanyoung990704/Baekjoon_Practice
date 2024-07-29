import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] topping) {        
        
        Map<Integer, Integer> person1 = new HashMap<>();
        Map<Integer, Integer> person2 = new HashMap<>();
        
        for(int t : topping){
            person2.put(t, person2.getOrDefault(t, 0) + 1);
        }
        
        int res = 0;

        for(int i = 0 ; i < topping.length ; i++){
            int cur = topping[i];
            
            person1.put(cur, person1.getOrDefault(cur, 0) + 1);
            person2.put(cur, person2.get(cur) - 1);
            
            if(person2.get(cur) <= 0){
                person2.remove(cur);
            }
            
            if(person1.keySet().size() == person2.keySet().size()){
                res++;
            }
            
        }
        

        
        return res;
        
    }
}