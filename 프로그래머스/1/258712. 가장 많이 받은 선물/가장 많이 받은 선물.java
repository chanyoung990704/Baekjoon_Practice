import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> giftAdj = new HashMap<>(); // 간선 역할
        Map<String, Integer> getGift = new HashMap<>(); // 선물 받은 횟수
        Map<String, Integer> giveGift = new HashMap<>(); // 선물 준 횟수
        Map<String, Integer> result = new HashMap<>();
        
        // 초기화
        for (String friend : friends) {
            getGift.put(friend, 0);
            giveGift.put(friend, 0);
            result.put(friend, 0);
        }
        
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            giftAdj.put(gift, giftAdj.getOrDefault(gift, 0) + 1);
            giveGift.put(parts[0], giveGift.get(parts[0]) + 1);
            getGift.put(parts[1], getGift.get(parts[1]) + 1);
        }
        
        // 로직
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String p1 = friends[i];
                String p2 = friends[j];
                
                String p1p2 = p1 + " " + p2;
                String p2p1 = p2 + " " + p1;
                
                int p1ToP2 = giftAdj.getOrDefault(p1p2, 0);
                int p2ToP1 = giftAdj.getOrDefault(p2p1, 0);
                
                // 선물 주고 받은 기록 없거나 같은 경우
                if (p1ToP2 == p2ToP1) {
                    // 선물 지수 계산
                    int p1Score = giveGift.get(p1) - getGift.get(p1);
                    int p2Score = giveGift.get(p2) - getGift.get(p2);
                    if (p1Score > p2Score) {
                        result.put(p1, result.get(p1) + 1);
                    } else if (p2Score > p1Score) {
                        result.put(p2, result.get(p2) + 1);
                    }
                } else {
                    String nextP = p1ToP2 > p2ToP1 ? p1 : p2;
                    result.put(nextP, result.get(nextP) + 1);
                }
            }
        }
        
        return result.values().stream().mapToInt(Integer::intValue).max().orElse(0);
    }
}