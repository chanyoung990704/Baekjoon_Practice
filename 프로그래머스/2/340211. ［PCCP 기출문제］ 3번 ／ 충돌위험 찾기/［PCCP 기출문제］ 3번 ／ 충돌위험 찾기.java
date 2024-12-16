import java.util.*;

class Solution {
    private static int[][][] cnt;
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int maxTime = 0;
        cnt = new int[15000][100][100];

        for(int[] r : routes){
            int t = 0;
            for(int i = 0 ; i < r.length - 1; i++) {
                int y = points[r[i] - 1][0] - 1;
                int x = points[r[i] - 1][1] - 1;
                
                if(i == 0) cnt[t][y][x]++;

                int ny = points[r[i + 1] - 1][0] - 1;
                int nx = points[r[i + 1] - 1][1] - 1;
                               
                while(y != ny){
                    t++;
                    if(y < ny) y++;
                    else y--;
                    cnt[t][y][x]++;
                }
                
                while(x != nx){
                    t++;
                    if(x < nx) x++;
                    else x--;
                    cnt[t][y][x]++;
                }
                    
            }
            maxTime = Math.max(maxTime, t);
        }
        
        for(int i = 0 ; i < cnt.length ; i++) {
            for(int y = 0 ; y < 100 ; y++)
                for(int x = 0 ; x < 100 ; x++)
                    if(cnt[i][y][x] > 1) answer++;
        }
        
        return answer;
    }
}