import java.util.*;

class Solution {
    // 다음 빈 방을 찾는 find 함수
    private long find(long room, Map<Long, Long> parent) {
        // 해당 방이 비어있는 경우
        if (!parent.containsKey(room)) {
            parent.put(room, room + 1);  // 다음 방을 가리키도록 설정
            return room;
        }
        
        // 경로 압축을 통한 최적화
        long nextRoom = find(parent.get(room), parent);
        parent.put(room, nextRoom);
        return nextRoom;
    }
    
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        Map<Long, Long> parent = new HashMap<>();
        
        // 각 고객에 대해 방 배정
        for (int i = 0; i < n; i++) {
            answer[i] = find(room_number[i], parent);
        }
        
        return answer;
    }
}
