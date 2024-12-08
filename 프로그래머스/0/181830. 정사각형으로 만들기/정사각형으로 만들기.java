import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] arr) {
        
        int y = arr.length;
        int x = arr[0].length;
        List<List<Integer>> list = new ArrayList<>();

        if(y > x){
            int cnt = y - x;
            for(int i = 0 ; i < y ; i++){
                List<Integer> sub = Arrays.stream(arr[i]).boxed().collect(Collectors.toList());
                sub.addAll(Collections.nCopies(cnt, 0));
                list.add(sub);
            }
            return list.stream().map(i -> {
                return i.stream().mapToInt(Integer::valueOf).toArray();
            }).toArray(int[][]::new);            
        }else if(y < x){
            int cnt = x - y;
            for(int i = 0 ; i < y ; i++)
                list.add(Arrays.stream(arr[i]).boxed().collect(Collectors.toList()));
            for(int i = 0 ; i < cnt ; i++)
                list.add(Collections.nCopies(arr[0].length, 0));
            
            return list.stream().map(i -> {
                return i.stream().mapToInt(Integer::valueOf).toArray();
            }).toArray(int[][]::new);  
        }else{
            return arr;
        }
    }
}