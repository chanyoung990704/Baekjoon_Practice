import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] quiz) {
        
        return Arrays.stream(quiz)
            .map(s -> {
                String[] arr = s.split(" ");
                int x = Integer.valueOf(arr[0]);
                int y = Integer.valueOf(arr[2]);
                int z = Integer.valueOf(arr[4]);
                
                String ret;
                if(arr[1].equals("+")){
                    ret = (x + y == z) ? "O" : "X";
                }else{
                    ret = (x - y == z) ? "O" : "X";
                }
                
                return ret;
            })
            .toArray(String[]::new);
        
    }
}