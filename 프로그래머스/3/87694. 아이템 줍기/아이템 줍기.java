import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // 이동 가능 영역
        int[][] move = new int[102][102]; // y, x
        for(int[] r : rectangle){
            // 2배
            for(int i = 0 ; i < 4;  i++){
                r[i] *= 2;
            }
            
            for(int i = r[0] ; i <= r[2] ; i++){
                for(int j = r[1] ; j <= r[3] ; j++){
                    // 테두리
                    if(i == r[0] || i == r[2] || j == r[1] || j == r[3]){
                        // 내부가 아닐때
                        if(move[j][i] != 2){
                            move[j][i] = 1;
                        }
                    }
                    else{
                        move[j][i] = 2;
                    }
                }
            }
        }
        
        // 2배
        characterY *= 2;
        characterX *= 2;
        itemX *= 2;
        itemY *= 2;
        
        // BFS
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{characterY, characterX, 0});
        boolean[][] visited = new boolean[102][102];
        visited[characterY][characterX] = true;
        
        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int y = cur[0];
            int x = cur[1];
            int cnt = cur[2];
            
            // 도착
            if(y == itemY && x == itemX){
                return cnt / 2;
            }
            
            int[] dy = new int[]{0,0,1,-1};
            int[] dx = new int[]{1,-1,0,0};
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(move[ny][nx] == 1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    dq.offer(new int[]{ny, nx, cnt + 1});
                }
            }
        }
        
        int answer = 0;
        return answer;
    }
}