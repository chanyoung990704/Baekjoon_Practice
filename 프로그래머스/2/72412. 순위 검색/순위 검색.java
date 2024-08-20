import java.util.*;
import java.util.stream.*;

class Solution {
    class Person {
        String lang;
        String position;
        String level;
        String food;
        int score;
        
        Person(String lang, String position, String level, String food, int score) {
            this.lang = lang;
            this.position = position;
            this.level = level;
            this.food = food;
            this.score = score;
        }
    }
    
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        // 모든 가능한 조합을 생성하여 map에 저장
        for (String i : info) {
            String[] parts = i.split(" ");
            String[] langs = {parts[0], "-"};
            String[] positions = {parts[1], "-"};
            String[] levels = {parts[2], "-"};
            String[] foods = {parts[3], "-"};
            int score = Integer.parseInt(parts[4]);
            
            for (String lang : langs) {
                for (String position : positions) {
                    for (String level : levels) {
                        for (String food : foods) {
                            String key = lang + position + level + food;
                            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
                        }
                    }
                }
            }
        }
        
        // 각 리스트를 정렬
        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }
        
        int[] answer = new int[query.length];
        
        for (int i = 0; i < query.length; i++) {
            String[] parts = query[i].replace(" and ", " ").split(" ");
            String key = parts[0] + parts[1] + parts[2] + parts[3];
            int score = Integer.parseInt(parts[4]);
            
            if (map.containsKey(key)) {
                List<Integer> scores = map.get(key);
                // 이진 탐색으로 조건에 맞는 점수의 시작 인덱스를 찾음
                int startIdx = binarySearch(scores, score);
                answer[i] = scores.size() - startIdx;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private int binarySearch(List<Integer> scores, int target) {
        int left = 0, right = scores.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}