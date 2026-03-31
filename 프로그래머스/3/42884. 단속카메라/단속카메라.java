import java.util.*;
import java.util.stream.*;

class Solution {
    int[][] routes;
    int answer = 0;
    public int solution(int[][] routes) {
        this.routes = routes;
        
        // 끝점 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        // 스위핑 알고리즘
        int lastCamera = -1000000;
        
        for(int[] r : routes){
            // 시작점이 더 늦게 나온다면
            if(r[0] > lastCamera){
                answer++;
                lastCamera = r[1];
            }
        }
        
        return answer;
    }
}