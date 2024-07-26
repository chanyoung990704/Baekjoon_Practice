import java.util.*;
import java.util.stream.*;

class Solution {
    
    class Song {
        int idx;
        int cnt;
        
        Song(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
        
        int getCnt() {
            return cnt;
        }
        
        int getIdx() {
            return idx;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        // 재생 횟수 Map
        Map<String, Integer> playCntMap = new HashMap<>();
        Map<String, PriorityQueue<Song>> playMap = new HashMap<>();
        
        // 초기화
        for(int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            
            playCntMap.put(g, playCntMap.getOrDefault(g, 0) + p);
            playMap.computeIfAbsent(g, k -> new PriorityQueue<>(
                Comparator.comparing(Song::getCnt).reversed()
                .thenComparing(Comparator.comparing(Song::getIdx))
            )).offer(new Song(i, p));
        }
        
        return Arrays.stream(genres)
            .distinct()
            .sorted(Comparator.comparing(playCntMap::get).reversed())
            .flatMap(genre -> {
                PriorityQueue<Song> pq = playMap.get(genre);
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < 2 && !pq.isEmpty(); i++) {
                    list.add(pq.poll().getIdx());
                }
                return list.stream();
            })
            .mapToInt(Integer::valueOf)
            .toArray();
        
    }
}