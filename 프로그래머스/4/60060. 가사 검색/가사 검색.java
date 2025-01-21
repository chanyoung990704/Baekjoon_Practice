import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        // 정방향, 역방향 맵 생성
        Map<Integer, List<String>> forwardMap = new HashMap<>();
        Map<Integer, List<String>> backwardMap = new HashMap<>();
        
        // 단어 저장
        for(String word : words){
            forwardMap.computeIfAbsent(word.length(), (key) -> new ArrayList<>()).add(word);
            backwardMap.computeIfAbsent(word.length(), (key) -> new ArrayList<>())
                      .add(new StringBuilder(word).reverse().toString());
        }
        
        // 정렬
        for(Map.Entry<Integer, List<String>> e : forwardMap.entrySet()){
            e.getValue().sort(Comparator.naturalOrder());
        }
        for(Map.Entry<Integer, List<String>> e : backwardMap.entrySet()){
            e.getValue().sort(Comparator.naturalOrder());
        }
        
        List<Integer> res = new ArrayList<>();
        // 쿼리 탐색
        for(String q : queries){
            if(!forwardMap.containsKey(q.length())){
                res.add(0);
                continue;
            }
            
            List<String> list;
            String target;
            
            // 접미사에 ?가 있는 경우 (fro??)
            if(q.endsWith("?")){
                target = q.substring(0, q.indexOf('?'));
                list = forwardMap.get(q.length());
            }
            // 접두사에 ?가 있는 경우 (????o)
            else {
                target = new StringBuilder(q.substring(q.lastIndexOf('?') + 1)).reverse().toString();
                list = backwardMap.get(q.length());
            }
            
            // 상한값 찾기
            int lo = 0;
            int hi = list.size() - 1;
            int searched = list.size();
            
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if(target.compareTo(list.get(mid).substring(0, target.length())) <= 0) {
                    searched = mid;
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }
            
            // 값이 없으면 
            if(searched == list.size()){
                res.add(0);
                continue;
            }
            
            // 하한값 찾기
            lo = 0;
            hi = list.size() - 1;
            int lowSearched = -1;
            
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if(target.compareTo(list.get(mid).substring(0, target.length())) < 0) {
                    hi = mid - 1;
                }else{
                    lowSearched = mid;
                    lo = mid + 1;
                }
            }        
            
            res.add(lowSearched - searched + 1);
        }
        
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
