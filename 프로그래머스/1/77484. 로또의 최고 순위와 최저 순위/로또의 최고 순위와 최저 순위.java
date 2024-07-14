import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int lottoRank(int n){
        if(n == 6)
            return 1;
        else if (n == 5)
            return 2;
        else if(n == 4)
            return 3;
        else if(n == 3)
            return 4;
        else if(n == 2)
            return 5;
        else
            return 6;
    }
    
    public int[] solution(int[] lottos, int[] win_nums) {
        
        Set<Integer> set = Arrays.stream(win_nums).boxed().collect
            (Collectors.toSet());

        
        int min = (int)Arrays.stream(lottos)
            .filter(i -> set.contains(i))
            .count();
        
        int max = (int)Arrays.stream(lottos)
            .filter(i -> i == 0 || set.contains(i))
            .count();
        
        return new int[]{lottoRank(max), lottoRank(min)};
        
    }
}