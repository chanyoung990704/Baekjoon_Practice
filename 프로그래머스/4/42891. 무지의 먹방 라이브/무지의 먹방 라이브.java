import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        long totalTime = 0;
        
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Integer[]{i + 1, food_times[i]});
            totalTime += food_times[i];
        }
        
        if (totalTime <= k) return -1;
        
        long cycleTime = 0;
        int prevTime = 0;
        long foodCount = food_times.length;
        
        while ((cycleTime + (pq.peek()[1] - prevTime) * foodCount) <= k) {
            Integer[] current = pq.poll();
            cycleTime += (long)(current[1] - prevTime) * foodCount;
            foodCount--;
            prevTime = current[1];
        }
        
        List<Integer[]> remainingFoods = new ArrayList<>(pq);
        remainingFoods.sort((a, b) -> a[0] - b[0]);
        
        long remainingK = k - cycleTime;
        return remainingFoods.get((int)(remainingK % foodCount))[0];
    }
}