import java.util.*;

class Solution {
    int INF = 1000000000;
    
    int answer = INF;
    
    int[] dr = new int[]{-1,0,1,0};
    int[] dc = new int[]{0,1,0,-1};
    
    int R,C;
    
    int straight = 100;
    int cornor = 500;
    
    public int solution(int[][] board) {
        R = board.length; C = board[0].length;
        
        int[][][] dist = new int[4][R][C];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < R; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        if (board[0][1] == 0) {
            q.offer(new int[]{0, 1, 100, 1}); // 오른쪽
            dist[1][0][1] = 100;
        }
        if (board[1][0] == 0) {
            q.offer(new int[]{1, 0, 100, 2}); // 아래쪽
            dist[2][1][0] = 100;
        }
        
        while(!q.isEmpty()){
            int[] P = q.poll();
            int r = P[0], c = P[1], cost = P[2], D = P[3];
            
            for(int d = 0 ; d < 4 ; d++){
                int nr = r + dr[d], nc = c + dc[d];
                if(range(nr,nc) && board[nr][nc] == 0){
                    int next = cost + straight;
                    if(d % 2 != D % 2){
                        next += cornor;
                    }
                    
                    if(dist[d][nr][nc] > next){
                        dist[d][nr][nc] = next;
                        q.offer(new int[]{nr,nc,next,d});
                    }
                }
            }
        }
        
        for(int d = 0 ; d < 4 ; d++){
            answer = Math.min(answer, dist[d][R-1][C-1]);
        }
        
        return answer;
    }
    
    boolean range(int r, int c){
        return r>=0&&r<R&&c>=0&&c<C;
    }
}