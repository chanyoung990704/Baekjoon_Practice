class Solution {
    public String solution(String my_string, int m, int c) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < my_string.length() ; i += m){
            String sub = my_string.substring(i, Math.min(i + m, my_string.length()));
            if(sub.length() >= c) sb.append(sub.charAt(c - 1));
        }
        
        return sb.toString();
    }
}