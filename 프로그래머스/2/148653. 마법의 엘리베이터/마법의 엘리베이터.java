import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(String.valueOf(storey));
        sb.reverse();
        
        for (int i = 0; i < sb.length(); i++) {
            int cur = sb.charAt(i) - '0';
            if (cur < 5) {
                answer += cur;
            } else if (cur > 5) {
                answer += (10 - cur);
                if (i != sb.length() - 1) {
                    int n = sb.charAt(i + 1) - '0';
                    sb.setCharAt(i + 1, (char) (n + 1 + '0'));
                } else {
                    answer += 1;
                }
            } else {
                if (i != sb.length() - 1 && sb.charAt(i + 1) >= '5') {
                    int n = sb.charAt(i + 1) - '0';
                    sb.setCharAt(i + 1, (char) (n + 1 + '0'));
                }
                answer += cur;
            }
        }
        
        return answer;
    }
}