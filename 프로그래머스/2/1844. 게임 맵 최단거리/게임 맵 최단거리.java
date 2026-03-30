import java.util.*;

class Solution {
    int[][] maps;
    
    int[] dy = new int[]{0,0,1,-1};
    int[] dx = new int[]{1,-1,0,0};
    
    int sy, sx, ey, ex;
    
    int answer = 987654321;
    public int solution(int[][] maps) {
        this.maps = maps;
        
        // BFS
        Queue<int[]> q = new ArrayDeque<>();

        sy = sx = 0;
        ey = maps.length-1;
        ex = maps[0].length-1;
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        q.add(new int[]{sy,sx, 1});
        visited[sy][sx]=true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int cnt = cur[2];
            
            if(y == ey && x == ex){
                answer = Math.min(answer, cnt);
            }
            
            for(int d = 0 ; d < 4 ; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(range(ny,nx) && maps[ny][nx] == 1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny,nx,cnt+1});
                }
            }
        }
        
        
        return answer == 987654321 ? -1 : answer;
    }
    
    boolean range(int y, int x){
        return y >= 0 && y < maps.length && x >= 0 && x < maps[0].length;
    }
}