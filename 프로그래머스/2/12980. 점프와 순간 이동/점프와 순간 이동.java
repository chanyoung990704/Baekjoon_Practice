import java.util.*;

public class Solution {
    public int solution(int n) {
        int result = 0;
        
        while(n != 0){
            if(n % 2 == 1){
                result++;
                n--;
            }
            n /= 2;
        }
        
        return result;
    }
}