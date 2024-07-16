class Solution {
    
    int sy = -1;
    int sx = -1;
    String[] park;
    
    public int[] solution(String[] park, String[] routes) {
        
        this.park = park;
        
        for(int i = 0 ; i < park.length ; i++)
            for(int j = 0 ; j < park[0].length() ; j++)
                if(park[i].charAt(j) == 'S'){
                    sy = i;
                    sx = j;
                }
        
        for(String route : routes)
            moveIdx(route);
        
        return new int[]{sy, sx};
    }
    
    void moveIdx(String s) {
        String[] splitS = s.split(" ");
        String op = splitS[0];
        int n = Integer.valueOf(splitS[1]);
            
        int ny = sy;
        int nx = sx;
        
        boolean canMove = true;
        
        for(int i = 1; i <= n; i++) {
            if(op.equals("E")){
                nx++;
            }else if(op.equals("S")){
                ny++;
            }else if(op.equals("W")){
                nx--;
            }else{
                ny--;
            }
            
            if(ny < 0 || ny >= park.length || nx < 0 || nx >= park[0].length() || park[ny].charAt(nx) == 'X'){
                canMove = false;
                break;
            }
        }
        
        if(canMove){
            this.sy = ny;
            this.sx = nx;
        }
    }
}