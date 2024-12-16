import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int maxPossibleTime = 20000; // 최대 좌표가 100이므로, 최대 이동 시간은 200을 넘지 않음
        int[][][] cnt = new int[maxPossibleTime + 1][100][100];
        int answer = 0;
        int maxTime = 0;
        
        for(int[] r : routes){
            int t = 0;
            for(int i = 0 ; i < r.length - 1; i++) {
                int y = points[r[i] - 1][0] - 1;
                int x = points[r[i] - 1][1] - 1;
                
                if(i == 0 && t < maxPossibleTime) cnt[t][y][x]++;

                int ny = points[r[i + 1] - 1][0] - 1;
                int nx = points[r[i + 1] - 1][1] - 1;
                               
                while(y != ny){
                    t++;
                    if(t >= maxPossibleTime) break; // 범위 체크 추가
                    if(y < ny) y++;
                    else y--;
                    cnt[t][y][x]++;
                }
                
                if(t >= maxPossibleTime) break;
                
                while(x != nx){
                    t++;
                    if(t >= maxPossibleTime) break; // 범위 체크 추가
                    if(x < nx) x++;
                    else x--;
                    cnt[t][y][x]++;
                }
                
                if(t >= maxPossibleTime) break;
            }
            maxTime = Math.max(maxTime, Math.min(t, maxPossibleTime - 1));
        }
        
        // 실제 발생한 maxTime까지만 확인
        for(int i = 0 ; i <= maxTime ; i++) {
            for(int y = 0 ; y < 100 ; y++)
                for(int x = 0 ; x < 100 ; x++)
                    if(cnt[i][y][x] > 1) answer++;
        }
        
        return answer;
    }
}
