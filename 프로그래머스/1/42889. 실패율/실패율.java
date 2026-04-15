import java.util.*;
import java.util.stream.*;


class Solution {
    public int[] solution(int N, int[] stages) {
        
        // 스테이지 도달 및 완료
        int[] cur = new int[N+2];
        int[] fin = new int[N+2];
        
        for(int s : stages){
            for(int j = 1 ; j <= s ; j++){
                cur[j]++;
                if(s > j){
                    fin[j]++;
                }
            }
        }
        
        return IntStream.range(1, N+1)
            .boxed() 
            .sorted(Comparator.comparingDouble(i -> (double) fin[i] / cur[i]))
            .mapToInt(Integer::intValue)
            .toArray();
        
        
    }
}