import java.util.*;

class Solution {
    int answer = 0;
    
    int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
    
    int LCM(int a, int b){
        return a * b / gcd(a, b);
    }
    
    public int solution(int[][] signals) {
        int[] total = new int[signals.length];
        int lcm = 1;
        
        for(int i = 0 ; i < signals.length ; i++){
            total[i] = signals[i][0] + signals[i][1] + signals[i][2];
            lcm = LCM(lcm, total[i]);
        }
        
        for(int i = 1 ; i <= lcm ; i++){
            boolean fin = true;
            
            for(int j = 0 ; j < signals.length ; j++){
                int cur = i % total[j];
                if(signals[j][0] < cur && cur <= signals[j][0] + signals[j][1]){
                    continue;
                }
                fin = false;
                break;
            }
            
            if(fin){
                return i;
            }
        }
        
        

        return -1;
    }
}