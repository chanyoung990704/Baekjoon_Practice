import java.util.*;
import java.util.stream.*;

class Solution {
    
    class Info{
        String genre;
        int idx;
        int plays;
        
        Info(String genre, int idx, int plays){
            this.genre = genre;
            this.idx = idx;
            this.plays = plays;
        }
        
        String getGenre(){
            return this.genre;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        // Map으로 만들기
        List<Info> list = new ArrayList<>();
        for(int i = 0 ; i < plays.length ; i++){
            list.add(new Info(genres[i], i, plays[i]));
        }
        Map<String, List<Info>> map = list.stream()
            .collect(Collectors.groupingBy(Info::getGenre));
        
        // 정렬하기
        map = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(
                Comparator.comparing(
                    (List<Info> l) -> l.stream().mapToInt(i -> Integer.valueOf(i.plays)).sum(),
                    Comparator.reverseOrder()
                )
            ))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (o, n) -> o,
                LinkedHashMap::new
            ));
        
        List<Integer> res = new ArrayList<>();
        
        for(Map.Entry<String, List<Info>> e : map.entrySet()){
            String k = e.getKey();
            List<Info> v = e.getValue();
            
            v.sort((a, b) -> {
                if(a.plays == b.plays){
                    return a.idx - b.idx;
                }
                return b.plays - a.plays;
            });
            
            for(int i = 0 ; i < v.size() ; i++){
                if(i == 2){
                    break;
                }
                res.add(v.get(i).idx);
            }
        }
        
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}