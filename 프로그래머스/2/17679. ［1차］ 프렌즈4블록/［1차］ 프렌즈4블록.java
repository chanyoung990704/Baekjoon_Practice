import java.util.*;

class Solution {
    
    int cnt = 0;
    
    public int solution(int m, int n, String[] board) {        
        StringBuilder[] sb = new StringBuilder[m];
        for(int i = 0 ; i < m ; i++){
            sb[i] = new StringBuilder(board[i]);
        }
        
        while(checkBlock(m, n, sb)){
            
        }
       
        return cnt;
    }
    
    
    boolean checkBlock(int m, int n, StringBuilder[] board) {
        boolean isPossible = false;
        boolean[][] toRemove = new boolean[m][n];

        // 2x2 블록 체크
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char cur = board[i].charAt(j);
                if (cur != 'x' &&
                    cur == board[i].charAt(j + 1) &&
                    cur == board[i + 1].charAt(j) &&
                    cur == board[i + 1].charAt(j + 1)) {
                    toRemove[i][j] = toRemove[i][j+1] = toRemove[i+1][j] = toRemove[i+1][j+1] = true;
                    isPossible = true;
                }
            }
        }
        
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++)
                if(toRemove[i][j])
                    cnt++;

        // 블록 제거 및 떨어뜨리기
        for (int j = 0; j < n; j++) {
            int writeIdx = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (toRemove[i][j]) {
                    board[i].setCharAt(j, 'x');
                } else if (board[i].charAt(j) != 'x') {
                    char temp = board[i].charAt(j);
                    board[i].setCharAt(j, 'x');
                    board[writeIdx].setCharAt(j, temp);
                    writeIdx--;
                }
            }
        }

        return isPossible;
    }
    
}