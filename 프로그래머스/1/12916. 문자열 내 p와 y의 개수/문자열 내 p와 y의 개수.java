class Solution {
    boolean solution(String s) {
        
        s = s.toLowerCase();
        
        int p_cnt = 0;
        int y_cnt = 0;
        
        for(char c : s.toCharArray()){
            if(c == 'p')
                p_cnt++;
            else if(c == 'y')
                y_cnt++;
        }
        
        return p_cnt == y_cnt;
    }
}