import java.util.*;

class Solution {
    String[] gems;
    Set<String> distinctGem;
    
    public int[] solution(String[] gems) {
        this.gems = gems;
        int len = gems.length;
        int end = 0;
        
        distinctGem = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemCount = new HashMap<>();
        List<int[]> answer = new ArrayList<>();
        
        for(int start = 0 ; start < len ; start++) {
            while(end < len && gemCount.size() < distinctGem.size()) {
                gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0) + 1);
                end++;
            }
            
            if(gemCount.size() == distinctGem.size()) {
                answer.add(new int[]{start + 1, end});
            }
            
            gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
            if(gemCount.get(gems[start]) == 0) {
                gemCount.remove(gems[start]);
            }
        }
        
        answer.sort((a, b) -> {
            if(a[1] - a[0] != b[1] - b[0])
                return (a[1] - a[0]) - (b[1] - b[0]);
            return a[0] - b[0];
        });
        
        return answer.get(0);
    }
}