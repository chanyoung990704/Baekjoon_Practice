import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        
        Map<String, List<Integer>> map = new HashMap<>();
        for(String i : info) {
            String[] parsed = i.split(" ");
            for(String lang : List.of(parsed[0], "-"))
                for(String work : List.of(parsed[1], "-"))
                    for(String level : List.of(parsed[2], "-"))
                        for(String food : List.of(parsed[3], "-")){
                            String k = lang + work + level + food;
                            int score = Integer.valueOf(parsed[4]);
                            map.computeIfAbsent(k, key -> new ArrayList<>()).add(score);
                        }
        }
        
        for(List<Integer> l : map.values()) Collections.sort(l);
        
        
        int[] answer = new int[query.length];
        
        for(int i = 0 ; i < query.length ; i++){
            String[] parsed = query[i].replaceAll(" and ", " ").split(" ");
            String key = parsed[0] + parsed[1] + parsed[2] + parsed[3];
            int score = Integer.valueOf(parsed[4]);
            
            if(map.containsKey(key)){
                int min = getMinIdx(map.get(key), score);
                answer[i] = map.get(key).size() - min;
            }else{
                answer[i] = 0;
            }
            
        }
        
        return answer;
    }
    
    int getMinIdx(List<Integer> l, int score){
        int lo = 0;
        int hi = l.size() - 1;
        int ret = l.size();
        
        while(lo <= hi){
            
            int mid = (lo + hi) / 2;
            if(l.get(mid) < score){
                lo = mid + 1;
            }else{
                ret = mid;
                hi = mid - 1;
            }
            
        }
        
        
        return ret;
    }
}