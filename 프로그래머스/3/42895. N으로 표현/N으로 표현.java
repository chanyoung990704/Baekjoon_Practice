import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        List<Set<Integer>> dpList = new ArrayList<>();
        for(int i = 0 ; i <= 8 ; i++) dpList.add(new HashSet<>());
        
        String strN = String.valueOf(N);
        for(int i = 1 ; i <= 8 ; i++) dpList.get(i).add(Integer.parseInt(strN.repeat(i)));
        
        for(int i = 1 ; i <= 8 ; i++){
            for(int j = 1 ; j < i ; j++)
                for(int j_num : dpList.get(j))
                    for(int opposite_num : dpList.get(i - j)){
                        Set<Integer> curSet = dpList.get(i);
                        curSet.add(j_num + opposite_num);
                        curSet.add(j_num - opposite_num);
                        curSet.add(j_num * opposite_num);
                        if(opposite_num != 0) curSet.add(j_num / opposite_num);
                    }                 
            
            if(dpList.get(i).contains(number)) return i;
        }  
        return -1;
    }
}