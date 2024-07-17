import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        int cnt = 0;
        int removeZero = 0;
        while(s.length() != 1) {
            cnt++;
            
            // 0 제거
            int removeLen = s.replaceAll("0", "").length();
            removeZero += s.length() - removeLen;
            // 제거 후 길이
            s = Integer.toBinaryString(removeLen);
        }
        
        
        return new int[]{cnt, removeZero};
    }
}