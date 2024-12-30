import java.util.*;
import java.util.stream.*;

class Solution {
    
    int max = 0;
    List<Integer> result;
    int[] info;
    
    public int[] solution(int n, int[] info) {
        this.info = info;
        int[] answer = {};
        permutation(n, new ArrayList<>());
        
        if(max == 0) return new int[]{-1};
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    
    
    void permutation(int n, List<Integer> list){
        if(list.size() == 11){
            if(n > 0) return;
            
            int lion = 0;
            int appeach = 0;
            for(int i = 0 ; i < 11 ; i++){
                if(info[i] == 0 && list.get(i) == 0) continue;
                if(info[i] >= list.get(i)) appeach += (10 - i);
                else lion += (10 - i);
            }
            
            if(lion > appeach){
                int diff = lion - appeach;
                if(diff > max){
                    max = diff;
                    result = new ArrayList<>(list);
                }else if(diff == max){
                    for(int i = 10 ; i >= 0 ; i--){
                        if(result.get(i) > list.get(i)) break;
                        else if(result.get(i) < list.get(i)) result = new ArrayList<>(list);
                    }
                }
            }
            
            return;
        }
        
        for(int i = 0 ; i <= n; i++){
            list.add(i);
            permutation(n - i, list);
            list.remove(list.size() - 1);
        }
    }
}