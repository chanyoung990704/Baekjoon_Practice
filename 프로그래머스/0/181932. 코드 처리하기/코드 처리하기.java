class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        
        int mode = 0;
        int idx = 0;
        for(char c : code.toCharArray()){
            if(c == '1') mode = mode == 0 ? 1 : 0;
            else if(idx % 2 == 0 && mode == 0) sb.append(c);
            else if(idx % 2 == 1 && mode == 1) sb.append(c);
            idx++;
        }
        
        if(sb.toString().equals("")) return "EMPTY";
        return sb.toString();
    }
}