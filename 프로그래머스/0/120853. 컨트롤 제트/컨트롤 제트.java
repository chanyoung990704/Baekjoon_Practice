import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        
        List<Integer> list = new ArrayList<>();
        
        Arrays.stream(s.split(" "))
            .forEach(i -> {
                if(i.equals("Z") && !list.isEmpty())
                    list.remove(list.size() - 1);
                else
                    list.add(Integer.valueOf(i));
            });
        
        
        return (int)list.stream()
            .mapToInt(Integer::valueOf)
            .sum();
        
    }
}