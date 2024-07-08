import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= (int)Math.sqrt(n) ; i++)
            if(n % i == 0){
                list.add(i);
                if(n / i != i)
                    list.add(n / i);
            }
        
        return list.stream()
            .sorted()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}