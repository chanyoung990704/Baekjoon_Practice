import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 도착시간 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        // 겹치는 구간 찾기
        int cnt = 0;
        int start = 0;
        int end = -50000;
        
        for(int i = 0 ; i < routes.length ; i++){
            int[] cur = routes[i];
            // 새로운 구간의 시작이면
            if(end < cur[0]){
                // 구간 개수 
                cnt++;
                // 초기화
                start = cur[0];
                end = cur[1];
            }
        }
        
        return cnt;
    }
}