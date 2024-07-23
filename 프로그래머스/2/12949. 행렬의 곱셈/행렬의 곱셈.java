import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 2차원 배열 저장용 리스트
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0 ; i < arr1.length ; i++){
            List<Integer> l = new ArrayList<>();
            for(int j = 0 ; j < arr2[0].length ; j++){
                int sum = 0;
                for(int k = 0 ; k < arr1[0].length ; k++) {    
                    sum += (arr1[i][k] * arr2[k][j]);
                }
                l.add(sum);
            }
            list.add(l);
        }

        
        return list.stream().
            map(l -> l.stream().mapToInt(Integer::valueOf)
               .toArray())
            .toArray(int[][]::new);
            
    }
}