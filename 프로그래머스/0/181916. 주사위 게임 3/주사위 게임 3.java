import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(a, m.getOrDefault(a, 0) + 1);
        m.put(b, m.getOrDefault(b, 0) + 1);
        m.put(c, m.getOrDefault(c, 0) + 1);
        m.put(d, m.getOrDefault(d, 0) + 1);
        
        switch(m.size()){
            case 4:
                return Collections.min(m.keySet());
            case 1:
                return 1111 * a;
            case 3:
                int ret = 1;
                for(Map.Entry<Integer, Integer> e : m.entrySet()){
                    if(e.getValue() == 1) ret *= e.getKey();
                }
                return ret;
            default:
                List<Integer> l = List.of(a,b,c,d).stream()
                    .distinct()
                    .sorted(Comparator.comparing(i -> m.get(i)))
                    .collect(Collectors.toList());
                if(m.get(l.get(0)) == 1){
                    return (10 * l.get(1) + l.get(0)) * (10 * l.get(1) + l.get(0));
                }else{
                    return (l.get(0) + l.get(1)) * Math.abs(l.get(0) - l.get(1));
                }
        }

    }
}