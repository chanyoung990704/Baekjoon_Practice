class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        // length
        if(!(s.length() == 4 || s.length() == 6)) return false;
        
        // All digit
        s = s.replaceAll("[0-9]", "");
        if(!s.isEmpty()) return false;
        
        return answer;
    }
}