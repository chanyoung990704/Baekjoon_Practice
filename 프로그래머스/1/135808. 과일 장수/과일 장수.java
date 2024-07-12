import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        score = Arrays.stream(score)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::valueOf)
            .toArray();
        
        int result = 0;
        for(int i = 0 ; i < score.length - (m - 1) ; i += m) {
            result += score[i + m - 1] * m;
        }
        
        return result;
    }
}