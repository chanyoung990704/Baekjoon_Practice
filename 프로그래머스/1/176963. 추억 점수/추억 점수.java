import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < name.length ; i++)
            map.put(name[i], yearning[i]);
        
        
        return Arrays.stream(photo)
            .map(s -> (int) Arrays.stream(s)
                .map(j -> map.containsKey(j) ? map.get(j) : 0)
                .mapToInt(Integer::valueOf)
                .sum()
                )
            .mapToInt(Integer::valueOf)
            .toArray();
        
    }
}