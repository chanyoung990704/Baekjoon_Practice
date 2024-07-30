import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for(int[] command : commands){    
            List<Integer> cur = Arrays
                .stream(Arrays.copyOfRange(array, command[0] - 1, command[1]))
                .sorted()
                .boxed()
                .collect(Collectors.toList());
            answer.add(cur.get(command[2] - 1));
        }
        
        return answer.stream().mapToInt(Integer::valueOf)
            .toArray();
    }
}