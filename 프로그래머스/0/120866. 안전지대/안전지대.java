class Solution {
    
    int[] dy = new int[]{1, -1, 0, 0, -1, -1, 1, 1};
    int[] dx = new int[]{0, 0, 1, -1, -1, 1, -1, 1};
    
    public void isPossible(int y, int x, boolean[][] visited){
        
        visited[y][x] = true;
        
        for(int i = 0 ; i < 8 ; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny >= 0 && ny < visited.length && nx >= 0
              && nx < visited[0].length)
                visited[ny][nx] = true;
        }
    }
    
    public int solution(int[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0 ; i < board.length ; i++)
            for(int j = 0 ; j < board[0].length ; j++)
                if(board[i][j] == 1)
                    isPossible(i, j, visited);
        
        int answer = 0;
        
        for(boolean[] arr : visited)
            for(boolean cur : arr)
                if(!cur)
                    answer++;
                    
        
        return answer;
    }
}