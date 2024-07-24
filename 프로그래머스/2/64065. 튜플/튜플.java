import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        String[] nums = s.substring(1, s.length() - 1)
                           .replaceAll("[{}]", "")
                           .split(",");
        
        for(String num : nums){
            int n = Integer.valueOf(num);
            cntMap.put(n, cntMap.getOrDefault(n, 0) + 1);
            list.add(n);
        }
        
        
        return list.stream()
            .sorted(Comparator.comparing(i -> cntMap.get(i)).reversed())
            .distinct()
            .mapToInt(Integer::valueOf)
            .toArray();
        
    }
}