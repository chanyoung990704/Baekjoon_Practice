import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int pivot = routes[0][1];
        for(int i = 1 ; i < routes.length ; i++) {
            if(routes[i][0] > pivot){
                answer++;
                pivot = routes[i][1];
            }
            
        }
        
        return answer;
    }
}