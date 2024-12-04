import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        int idx = 1;
        List<Integer> list = new ArrayList<>();
        while(true){
            if(k * idx > n) break;
            list.add(k * idx++);
        }
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}