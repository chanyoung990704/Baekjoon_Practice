import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        
        String[] b = before.split("");
        String[] a = after.split("");
           
        Arrays.sort(b);
        Arrays.sort(a);
        
        return Arrays.equals(b, a) ? 1 : 0;
        
    }
}