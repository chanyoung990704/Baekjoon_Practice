import java.util.*;
import java.util.stream.*;

class Solution {
    
    int[] dy = new int[]{1,-1, 0, 0};
    int[] dx = new int[]{0, 0, 1, -1};
    
    int height;
    int weight;
    String color;
    String[][] board;
    
    public int getSameCnt(int h, int w) {
        int cnt = 0;
        for(int i = 0 ; i < 4 ; i++) {
            int ny = h + dy[i];
            int nx = w + dx[i];
            if(ny >= 0 && ny < height && nx >= 0 && nx < weight)
                if(board[ny][nx].equals(color))
                    cnt++;
        }
        return cnt;
    }
    
    public int solution(String[][] board, int h, int w) {
        this.board = board;
        this.height = board.length;
        this.weight = board[0].length;
        this.color = board[h][w];
        
        return getSameCnt(h, w);
    }
}