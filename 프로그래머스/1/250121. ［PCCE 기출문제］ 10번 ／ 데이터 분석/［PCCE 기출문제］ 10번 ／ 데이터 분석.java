import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        return Arrays.stream(data)
            .filter(i -> getValue(i, ext) < val_ext)
            .sorted(Comparator.comparing((int[] i) -> getValue(i, sort_by)))
            .toArray(int[][]::new);
    }

    
    int getValue(int[] item, String key){
        switch(key) {
            case "code" : return item[0];
            case "date" : return item[1];
            case "maximum" : return item[2];
            case "remain" : return item[3];
            default : return -1;
        }
    }
    
}