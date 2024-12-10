import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(condition1(wallet, bill) || condition2(wallet, bill)){
            
            if(bill[0] > bill[1]){
                bill[0] = bill[0] / 2;
            }else{
                bill[1] = bill[1] / 2;
            }
            answer++;
        }
        
        
        return answer;
    }
    
    boolean condition1(int[] wallet, int[] bill){
        return Math.min(wallet[0], wallet[1]) < Math.min(bill[0], bill[1]);
    }
    
    boolean condition2(int[] wallet, int[] bill){
        return Math.max(wallet[0], wallet[1]) < Math.max(bill[0], bill[1]);
    }
}