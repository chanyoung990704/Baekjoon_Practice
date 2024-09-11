import java.util.*;
import java.util.stream.*;

class Solution {
    int[] a;
    public int solution(int[] a) {
        this.a = a;
        int answer = 0;

        boolean[] leftMin = getLeftMin();
        boolean[] rightMin = getRightMin();
        
        for(int i = 0 ; i < a.length ; i++){
            if(leftMin[i] || rightMin[i]) answer++;
        }
        
    
        
        return answer;
    }
    
    boolean[] getLeftMin(){
        boolean[] ret = new boolean[a.length];
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < a.length ; i++){
            if(a[i] < min){
                min = a[i];
                ret[i] = true;
            }
        }
        return ret;
    }
    boolean[] getRightMin(){
        boolean[] ret = new boolean[a.length];
        int min = Integer.MAX_VALUE;
        for(int i = a.length - 1 ; i >= 0 ; i--){
            if(a[i] < min){
                min = a[i];
                ret[i] = true;
            }
        }
        return ret;
    }
}