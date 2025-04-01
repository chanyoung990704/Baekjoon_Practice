import java.util.*;
import java.util.stream.*;

class Solution {
    // 상하좌우
    int[] dy = new int[]{-1,1,0,0};
    int[] dx = new int[]{0,0,-1,1};
    int h, w;
    
    public int solution(int[][] board) {
        h = board.length;
        w = board[0].length;        
        
        // 다익스트라
        int[][][] cost = new int[h][w][4];
        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < w ; j++){
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing((List<Integer> li) -> li.get(0))); // 비용, 현재 방향, y, x
        pq.offer(List.of(0, 1, 0, 0));
        pq.offer(List.of(0, 3, 0, 0));
        cost[0][0][1] = 0;
        cost[0][0][3] = 0;
        
        while(!pq.isEmpty()){
            List<Integer> c = pq.poll();
            int ccost = c.get(0);
            int cdir = c.get(1);
            int y = c.get(2);
            int x = c.get(3);
            
            if(ccost > cost[y][x][cdir]){
                continue;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if((ny >= 0 && ny < h && nx >= 0 && nx < w) && board[ny][nx] == 0){
                    int nextCost = ccost + 100;
                    // 코너 건설
                    if((cdir == 0 || cdir == 1) && (i == 2 || i == 3)){
                        nextCost += 500;
                    }
                    if((cdir == 2 || cdir == 3) && (i == 0 || i == 1)){
                        nextCost += 500;
                    }
                    
                    if(nextCost < cost[ny][nx][i]){
                        cost[ny][nx][i] = nextCost;
                        pq.offer(List.of(nextCost, i, ny, nx));
                    }
                }
            }
        }
        
        int ret = Integer.MAX_VALUE;
        for(int i = 0 ; i < 4 ; i++){
            ret = Math.min(ret, cost[h-1][w-1][i]);
        }
        
        return ret;
    }
}