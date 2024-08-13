import java.util.*;
import java.util.stream.*;

class Solution {
    int[] dy = new int[]{0,0,1,-1};
    int[] dx = new int[]{1,-1,0,0};
    public int solution(String[] board) {        
        int[] start, end;
        start = end = null;
        
        Set<String> dSet = new HashSet<>();
        
        for(int i = 0 ; i < board.length ; i++)
            for(int j = 0 ; j < board[0].length() ; j++){
                if(board[i].charAt(j) == 'R') start = new int[]{i, j};
                else if(board[i].charAt(j) == 'G') end = new int[]{i, j};
                else if(board[i].charAt(j) == 'D') dSet.add(i +"," + j);
            }
        
        // BFS
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length()];
        
        dq.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        while(!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int y = cur[0]; int x = cur[1]; int cnt = cur[2];
            if(y == end[0] && x == end[1]) return cnt;
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = y; int nx = x;
                while(isPossible(ny + dy[i], nx + dx[i], board) &&
                     board[ny + dy[i]].charAt(nx + dx[i]) != 'D'){
                    ny += dy[i];
                    nx += dx[i];
                }
                
                if(!visited[ny][nx]){
                    visited[ny][nx] = true;
                    dq.offer(new int[]{ny, nx, cnt + 1});
                }
            }
            
        }
        
        
        return -1;
    }
    
    boolean isPossible(int y, int x, String[] board){
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length();
    }
    
}