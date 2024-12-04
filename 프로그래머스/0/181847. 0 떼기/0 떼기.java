class Solution {
    public String solution(String n_str) {
        StringBuilder sb = new StringBuilder();
        
        boolean lefted = true;
        for(char c : n_str.toCharArray()){
            if(c != '0') lefted = false;
            if(!lefted) sb.append(c);
        }
        
        return sb.toString();
    }
}