import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        // 음식 정보를 저장할 우선순위 큐 (최소 힙)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        // 음식 정보를 우선순위 큐에 저장 [인덱스, 소비 시간]
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new int[]{i + 1, food_times[i]});
        }
        
        long totalTime = 0;
        long previousTime = 0;
        int n = food_times.length;
        
        // 음식을 먹는 과정 시뮬레이션
        while (!pq.isEmpty()) {
            long diff = pq.peek()[1] - previousTime;
            long spentTime = diff * n;
            
            if (totalTime + spentTime > k) {
                break;
            }
            
            totalTime += spentTime;
            previousTime = pq.poll()[1];
            n--;
        }
        
        // 모든 음식을 다 먹은 경우
        if (pq.isEmpty()) {
            return -1;
        }
        
        // 남은 음식 중에서 다음 먹을 음식 찾기
        k -= totalTime;
        ArrayList<int[]> remainingFoods = new ArrayList<>(pq);
        remainingFoods.sort((a, b) -> a[0] - b[0]);  // 인덱스 기준 정렬
        
        return remainingFoods.get((int)(k % n))[0];
    }
}
