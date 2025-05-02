import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        
        int n = cards.length;
        
        Set<Integer> curs = new HashSet<>();
        for(int i = 0 ; i < n / 3; i++){
            curs.add(cards[i]);
        }
        
        Set<Integer> prevs = new HashSet<>();
        
        int answer = 1;
        int idx = n / 3;
        
        while(true){
            
            if(idx >= n){
                break;
            }
            
            // 카드 두장 뽑기
            for(int i = 0 ; i < 2 ; i++){
                prevs.add(cards[idx++]);
            }
            
            boolean isNext = false;
            
            // 노코인
            for(int cur : curs){
                int target = (n+1) - cur;
                if(curs.contains(target)){
                    curs.remove(cur);
                    curs.remove(target);
                    isNext = true;
                    break;
                }
            }

            // 1코인
            if(!isNext && coin >= 1){
                for(int cur : curs){
                    int target = (n+1) - cur;
                    if(prevs.contains(target)){
                        curs.remove(cur);
                        prevs.remove(target);
                        coin -= 1;
                        isNext = true;
                        break;
                    }
                }
            }
            
            // 2코인
            if(!isNext && coin >= 2){
                for(int prev : prevs){
                    int target = (n+1) - prev;
                    if(prevs.contains(target)){
                        prevs.remove(prev);
                        prevs.remove(target);
                        coin -= 2;
                        isNext = true;
                        break;
                    }
                }
            }
            
            if(!isNext){
                break;
            }
            
            answer++;
        }
        
        return answer;
    }
}