class Solution {
    public String solution(String s) {
        int len = s.length();
        
        StringBuilder sb = new StringBuilder();
        
        if(len % 2 == 0) {
            int idx = len / 2;
            sb.append(s.charAt(idx - 1));
            sb.append(s.charAt(idx));
        }else{
            int idx = len / 2;
            sb.append(s.charAt(idx));
        }
        
        return sb.toString();

    }
}