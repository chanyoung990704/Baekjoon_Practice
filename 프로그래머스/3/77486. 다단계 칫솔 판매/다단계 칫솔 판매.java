import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        Map<String, Integer> cost = new HashMap<>();
        for(int i = 0 ; i < enroll.length ; i++) cost.put(enroll[i], 0);
        cost.put("-", 0);
        Map<String, String> parent = new HashMap<>();
        for(int i = 0 ; i < enroll.length ; i++) {
            String child = enroll[i];
            String parentName = referral[i];
            parent.put(child, parentName);
        }
        
        
        for(int i = 0 ; i < seller.length ; i++) {
            int price = amount[i] * 100;
            String name = seller[i];
            cost.put(name, cost.get(name) + price);
            int remain = price;
            while(true){
                if(name.equals("-")) break;
                if(remain / 10 == 0) break;
                
                remain /= 10;
                // 자신의 것에서 10% 빼고 부모에게 배분한다.
                cost.put(name, cost.get(name) - remain);
                name = parent.get(name);
                cost.put(name, cost.get(name) + remain);
            }
        }
        
        return Arrays.stream(enroll)
            .mapToInt(i -> Integer.valueOf(cost.get(i)))
            .toArray();
    }
}