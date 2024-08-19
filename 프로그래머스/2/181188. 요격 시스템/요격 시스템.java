import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        int lastest = -1;
        for(int[] target : targets){
            if(target[0] > lastest){
                answer++;
                lastest = target[1] - 1;
            }
        }
        
        return answer;
    }
}