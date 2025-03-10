import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int N, int number) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1 ; i <= 8 ; i++){
            String nStr = String.valueOf(N).repeat(i);
            map.computeIfAbsent(i, k -> new ArrayList<>()).add(Integer.valueOf(nStr));
        }
        
        for(int i = 1 ; i <= 8 ; i++){
            List<Integer> l = map.get(i);
            
            for(int a = 1; a < i ; a++){
                int b = i - a;
                // 각각 구하기
                for(int na : map.get(a)){
                    for(int nb : map.get(b)){
                        l.add(na + nb);
                        l.add(na - nb);
                        l.add(na * nb);
                        if(nb != 0){
                            l.add(na / nb);
                        }
                    }
                }
            }
            
            if(l.contains(number)){
                return i;
            }
        }
        
        return -1;
    }
}