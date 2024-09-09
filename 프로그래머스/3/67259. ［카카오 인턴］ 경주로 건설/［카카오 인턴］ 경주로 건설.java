import java.util.*;

class Solution {
    int[][] board;
    int[][][] cost;
    public int solution(int[][] board) {
        this.board = board;
        cost = new int[board.length][board[0].length][4];
        for(int i = 0 ; i < board.length ; i++)
            for(int j = 0 ; j < board[0].length ; j++)
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
        
        dijkstra();
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0 ; i < 4 ; i++) 
            answer = Math.min(answer, cost[board.length - 1][board[0].length - 1][i]);
        return answer;
    }
    
    void dijkstra(){
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing((a) -> a.get(2)));
        pq.offer(List.of(0, 0, 0, -1));
        int[] dy = new int[]{0,0,-1,1};
        int[] dx = new int[]{1,-1,0,0};
        
        while(!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            
            if(cur.get(3) != -1 && cur.get(2) > cost[cur.get(0)][cur.get(1)][cur.get(3)]) continue;
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = cur.get(0) + dy[i];
                int nx = cur.get(1) + dx[i];
                if(ny >= 0 && ny < board.length && nx >= 0 && nx < board[0].length)
                    if(board[ny][nx] == 0){
                        int nextCost = cur.get(2) + 100;
                        if(cur.get(3) != -1 && cur.get(3) != i) nextCost += 500;
                        if(nextCost < cost[ny][nx][i]){
                            cost[ny][nx][i] = nextCost;
                            pq.offer(List.of(ny,nx,nextCost,i));
                        }
                    }
            }
        }
        
    }
}