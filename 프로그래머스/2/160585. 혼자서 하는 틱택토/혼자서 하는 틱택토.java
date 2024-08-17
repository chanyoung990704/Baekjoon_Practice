class Solution {
    public int solution(String[] board) {
        int countO = 0;
        int countX = 0;
        boolean oWin = false;
        boolean xWin = false;

        // O와 X의 개수 세기
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'O') countO++;
                if (c == 'X') countX++;
            }
        }

        // O와 X의 개수 차이 확인
        if (countO < countX || countO > countX + 1) return 0;

        // 승리 조건 확인
        for (int i = 0; i < 3; i++) {
            if (board[i].equals("OOO") || 
                (board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O')) {
                oWin = true;
            }
            if (board[i].equals("XXX") || 
                (board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X')) {
                xWin = true;
            }
        }

        // 대각선 승리 조건 확인
        if ((board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O') ||
            (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O')) {
            oWin = true;
        }
        if ((board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X') ||
            (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X')) {
            xWin = true;
        }

        // 승리 조건에 따른 유효성 검사
        if (oWin && xWin) return 0;
        if (oWin && countO <= countX) return 0;
        if (xWin && countO != countX) return 0;

        return 1;
    }
}