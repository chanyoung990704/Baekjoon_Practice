import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        int[] dr = new int[]{0,0,1,-1};
        int[] dc = new int[]{1,-1,0,0};
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0 ; i < m * n ; i++){
            int r = i / n, c = i % n;
            if(picture[r][c] > 0 && !visited[r][c]){
                visited[r][c] = true;
                q.offer(new int[]{r,c});
                int cnt = 0;
                
                while(!q.isEmpty()){
                    int[] p = q.poll();
                    cnt++;
                    
                    for(int d = 0 ; d < 4 ; d++){
                        int nr = p[0] + dr[d], nc = p[1] + dc[d];
                        if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                            if(picture[nr][nc] == picture[r][c] && !visited[nr][nc]){
                                q.offer(new int[]{nr,nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
                answer[0]++;
                answer[1] = Math.max(answer[1], cnt);
            }
        }
        
        
        return answer;
    }
}