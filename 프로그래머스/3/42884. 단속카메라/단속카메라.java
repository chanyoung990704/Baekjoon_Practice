import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int target = routes[0][1];
        int answer = 1;
        
        for(int i = 1; i < routes.length ; i++) {
            int start = routes[i][0];
            if(start > target){
                answer++;
                target = routes[i][1];
            }
        }
        
        return answer;
    }
}