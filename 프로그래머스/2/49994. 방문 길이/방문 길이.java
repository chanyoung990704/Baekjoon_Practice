import java.util.*;

class Solution {
    
    int cy = 0;
    int cx = 0;
    
    public int solution(String dirs) {
        int answer = 0;
        Set<String> s = new HashSet<>();
        
        for(String d : dirs.split("")){
            int ny = cy;
            int nx = cx;
            
            if(d.equals("U"))
                ny++;
            else if(d.equals("D"))
                ny--;
            else if(d.equals("L"))
                nx--;
            else if(d.equals("R"))
                nx++;
            
            if(isPossible(ny, nx)){
                
                String curNext = Math.min(cy,ny) + ","
                    + Math.min(cx, nx) + ","
                    + Math.max(cy, ny)+ ","
                    + Math.max(cx, nx);
                
                if(!s.contains(curNext)){
                    answer++;
                    s.add(curNext);

                }
                
                cy = ny;
                cx = nx;
                
            }
                
        }
        
        return answer;
    }
    
    
    boolean isPossible(int y, int x){
        return y >= -5 && y <= 5 && x >= -5 && x<= 5;
    }
}