import java.util.*;

class Solution {
    int answer = 0; // 원본 코드의 구조 및 변수 최대한 유지
    
    public int solution(String[] strs, String t) {
        
        int len = t.length();
        int[] dp = new int[len+1];
        int INF = 1000000000;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for(int i = 1 ; i <= len ; i++){
            for(String s : strs){
                int slen = s.length();
                
                if(i < slen){
                    continue; 
                }
                
                String sub = t.substring(i-slen, i); 
                if(sub.equals(s) && dp[i-slen] != INF){
                    dp[i] = Math.min(dp[i], dp[i-slen] + 1);
                }
            }
        }
        
        return dp[len] == INF ? -1 :dp[len];
    }
}