class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int h = board.length;
        int w = board[0].length;
        
        int[][] dmg = new int[h + 1][w + 1];
        for(int[] s : skill){
            int value = s[0] == 1 ? -s[5] : s[5];
            dmg[s[1]][s[2]] += value;
            dmg[s[1]][s[4] + 1] -= value;
            dmg[s[3] + 1][s[2]] -= value;
            dmg[s[3] + 1][s[4] + 1] += value;
        }
        
        for(int i = 0 ; i < h + 1 ; i++)
            for(int j = 1 ; j < w + 1 ; j++) dmg[i][j] += dmg[i][j - 1];
        
        for(int j = 0 ; j < w + 1 ; j++)
            for(int i = 1 ; i < h + 1 ; i++) dmg[i][j] += dmg[i - 1][j];
        
        for(int i = 0 ; i < h ; i++)
            for(int j = 0 ; j < w ; j++)
                if(board[i][j] + dmg[i][j] > 0) answer++;
        
        return answer;
    }
}