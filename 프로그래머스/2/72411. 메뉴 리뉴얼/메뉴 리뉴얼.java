import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        
        List<String> result = new ArrayList<>();
                
        for(int c : course) {
            Map<String, Integer> combinationCount = 
                new HashMap<>();
            
            for(String order : orders) {
                char[] orderArr = order.toCharArray();
                Arrays.sort(orderArr);
                findCombinations(orderArr, c, 0, "", combinationCount);
            }
            
            int max = 2;
            for(int curCount : combinationCount.values())
                if(curCount > max) max = curCount;
            
            for(Map.Entry<String, Integer> cur : combinationCount.entrySet()){
                if(cur.getValue() == max) result.add(cur.getKey());
            }
            
        }
        
        
        return result.stream()
            .sorted()
            .toArray(String[]::new);
    }
    
    
    private void findCombinations(char[] order, int len, int start,
                String cur, Map<String, Integer> combinationCount) {
        if(cur.length() == len){
            combinationCount.put(cur, 
                combinationCount.getOrDefault(cur, 0) + 1);
            return;
        }
        for(int i = start ; i < order.length ; i++)
            findCombinations(order, len, i + 1, cur + order[i],
                combinationCount);
    }
}