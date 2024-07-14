import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> list = new ArrayList<>();
        
        for (String t : targets) {
            int val = 0;
            for (char cur : t.toCharArray()) {
                int min = Integer.MAX_VALUE;
                for (String key : keymap) {
                    int index = key.indexOf(cur);
                    if (index != -1) {
                        min = Math.min(min, index + 1);
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    val = -1;
                    break;
                }
                val += min;
            }
            list.add(val);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}