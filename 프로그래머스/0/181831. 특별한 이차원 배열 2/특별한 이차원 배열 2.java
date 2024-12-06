import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] arr) {
        return bruteForce(arr);
    }
    
    int bruteForce(int[][] arr){
        int len = arr.length;
        
        for(int i = 0 ; i < len ; i++)
            for(int j = 0 ; j < len ; j++)
                if(arr[i][j] != arr[j][i]) return 0;
        return 1;
    }
}