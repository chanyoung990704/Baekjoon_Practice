import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        for(int mat : mats) {
            
            for(int i = 0 ; i < park.length - mat + 1 ; i++)
                for(int j = 0 ; j < park[0].length - mat + 1 ; j++){
                    if(isPossible(i, j, mat, park)){
                        answer = Math.max(answer, mat);
                    }
                }
            
        }
        
        return answer;
    }
    
    boolean isPossible(int i, int j, int m, String[][] p){
        for(int y = i ; y < i + m ; y++)
            for(int x = j ; x < j + m ; x++)
                if(!(p[y][x].equals("-1"))) return false;
        return true;
    }
}