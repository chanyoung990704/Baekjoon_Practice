import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(int n, int[] works) {
        
        // 우선순위 큐로 n번만큼 없애기
        
        // 무조건 0 인경우
        long total = Arrays.stream(works).sum();
        if(total<=n){
            return 0;
        }
        
        // 최대힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int w : works){
            pq.offer(w);
        }
        
        // n번만큼 줄이기
        while(n > 0){
            pq.offer(pq.poll() - 1);            
            n--;
        }
        
        // 야근지수 계산
        long answer = 0;
        int size = pq.size();
        
        while(!pq.isEmpty()){
            answer += (long)Math.pow(pq.poll(), 2);
        }
        
        
        return answer;
    }
}