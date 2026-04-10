import java.util.*;

class Solution {
    
    int[][] grid = new int[1000][1000];
    int answer = 0;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        //////////외곽선 따기///////////////////
        
        // 1. 모든 사각형의 영역을 1로 먼저 채움
        for(int[] rect : rectangle){
            for(int i = rect[0]*2; i <= rect[2]*2; i++)
                for(int j = rect[1]*2; j <= rect[3]*2; j++) grid[j][i] = 1;
        }

        // 2. 그 후에 모든 사각형의 내부를 2로 덮어씀
        for(int[] rect : rectangle){
            for(int i = rect[0]*2 + 1; i < rect[2]*2; i++)
                for(int j = rect[1]*2 + 1; j < rect[3]*2; j++) grid[j][i] = 2;
        }
        
        ////////////////BFS하기///////////////////
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.offer(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterY*2][characterX*2] = true;
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[1], c = p[0], cnt = p[2];
            
            if(r == itemY*2 && c == itemX*2){
                return cnt/2;
            }
            
            int[] dr = new int[]{0,0,1,-1};
            int[] dc = new int[]{1,-1,0,0};
            
            for(int d= 0 ; d< 4 ; d++){
                int nr = r + dr[d], nc = c + dc[d];
                if(nr >= 0 && nr <grid.length && nc >= 0 && nc < grid[0].length){
                    if(grid[nr][nc] == 1 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.offer(new int[]{nc,nr,cnt+1});
                    }
                }
            }
        }
        
        return answer;
    }
}