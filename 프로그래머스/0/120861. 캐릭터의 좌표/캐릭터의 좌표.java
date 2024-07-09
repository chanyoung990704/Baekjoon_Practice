class Solution {
    
    boolean isPossible(int y, int x, int by, int bx){
        return (int)Math.abs(y) <= by / 2 && (int)Math.abs(x) <= bx / 2; 
    }
    
    public int[] solution(String[] keyinput, int[] board) {
        
        int y = 0;  int x = 0;
        
        for(String k : keyinput) {
            int ny = y; int nx = x;
            
            if(k.equals("left")){
                nx--;
            }else if(k.equals("right")){
                nx++;
            }else if(k.equals("up")){
                ny++;
            }else if(k.equals("down")){
                ny--;
            }
            
            if(isPossible(ny, nx, board[1], board[0])){
                y = ny;
                x = nx;
            }
            
        }
        
        return new int[]{x, y};
    }
}