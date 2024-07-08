import java.util.*;

class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        
        answer = Objects.equals(num1, num2) ? 1 : -1;
        
        return answer;
    }
}