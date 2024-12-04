import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] num_list, int n) {
        List<Integer> list = Arrays.stream(num_list).boxed().sorted()
                                    .collect(Collectors.toList());
        
        int lo = 0;
        int hi = list.size() - 1;
        int answer = 0;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(list.get(mid) > n){
                hi = mid - 1;
            }else if(list.get(mid) < n){
                lo = mid + 1;
            }else{
                answer = 1;
                break;
            }
        }
        
        return answer;
    }
}