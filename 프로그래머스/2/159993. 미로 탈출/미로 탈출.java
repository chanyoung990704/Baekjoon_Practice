import java.util.*;
import java.util.stream.*;

class Solution {
    int[] dy = new int[]{0, 0, 1, -1};
    int[] dx = new int[]{1, -1, 0, 0};
    boolean[][] visited;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        int[] start = null, lever = null, exit = null;
        for(int i = 0 ; i < maps.length ; i++)
            for(int j = 0 ; j < maps[0].length() ; j++){
                if(maps[i].charAt(j) == 'S') start = new int[]{i, j};
                else if(maps[i].charAt(j) == 'L') lever = new int[]{i, j};
                else if(maps[i].charAt(j) == 'E') exit = new int[]{i, j};
            }
        
        int startToLever = bfs(start, lever, maps);
        int leverToExit = bfs(lever, exit, maps);
        
        if(startToLever == -1 || leverToExit == -1) return -1;
        
        return startToLever + leverToExit;
    }
    
    int bfs(int[] from, int[] to, String[] maps){
        visited = new boolean[maps.length][maps[0].length()];
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{from[0], from[1], 0});
        visited[from[0]][from[1]] = true;
        
        while(!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            if(cur[0] == to[0] && cur[1] == to[1]) return cur[2];
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny >= 0 && ny < maps.length && nx >= 0 && nx < maps[0].length())
                    if(!visited[ny][nx] && maps[ny].charAt(nx) != 'X') {
                        visited[ny][nx] = true;
                        dq.offer(new int[]{ny, nx, cur[2] + 1});
                    }
            }
            
        }
        
        return -1;
    }
}