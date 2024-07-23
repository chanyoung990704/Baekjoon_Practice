import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        // want number 매핑
        Map<String, Integer> cart = new HashMap<>();
        for(int i = 0 ; i < number.length ; i++){
            cart.put(want[i], number[i]);
        }
        
        // discount 수량 10개 매핑
        Map<String, Integer> sellOn = new HashMap<>();
        for(int i = 0 ; i < 10 ; i++){
            String item = discount[i];
            sellOn.put(item, sellOn.getOrDefault(item, 0) + 1);
        }
        
        // 결과 반환
        int result = 0;
        for(int i = 10 ; i <= discount.length ; i++){
            // 검사 로직
            boolean isPossible = true;
            for(int j = 0 ; j < want.length ; j++){
                String item = want[j];
                if(cart.get(item) != sellOn.getOrDefault(item, 0)){
                    isPossible = false;
                    break;
                }
            }
            
            if(isPossible)
                result++;
            
            // basecase
            if(i == discount.length)
                break;
            
            String prev = discount[i - 10];
            String cur = discount[i];
            
            sellOn.put(prev, sellOn.get(prev) - 1);
            sellOn.put(cur, sellOn.getOrDefault(cur, 0) + 1);
            
        }
        
        return result;
    }
}