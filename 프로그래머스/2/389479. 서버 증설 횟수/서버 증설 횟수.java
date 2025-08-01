import java.util.*;


class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
                
        for(int i = 0 ; i < players.length ; i++){
            // 증설 필요
            if(players[i] >= m){
                // 개수 파악
                int cnt = (players[i]) / m;
                answer += cnt;
                for(int j = i ; j < Math.min(players.length, i + k) ; j++){
                    players[j] -= (cnt * m);
                }
            }
        }
        
        return answer;
    }
}