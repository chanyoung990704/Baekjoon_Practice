import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] jobs) {
        
        PriorityQueue<List<Integer>> pq = 
            new PriorityQueue<>(Comparator.comparing((List<Integer> i) -> i.get(2))
                               .thenComparing((List<Integer> i) -> i.get(1))
                               .thenComparing((List<Integer> i) -> i.get(0))
                               );
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int totalTime = 0;
        int endTime = 0;
        int count = 0;
        int jobIdx = 0;
        
        while(count < jobs.length) {
            // 종료 시각 이전의 작업 모두 넣기
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= endTime){
                pq.offer(List.of(jobIdx, jobs[jobIdx][0], jobs[jobIdx][1]));
                jobIdx++;
            }
            
            if(pq.isEmpty()){
                endTime = jobs[jobIdx][0];
            }else{
                List<Integer> cur = pq.poll();
                totalTime += endTime - cur.get(1) + cur.get(2);
                endTime += cur.get(2);
                count++;
            }
            
        }
        
        
        int answer = 0;
        return totalTime / jobs.length;
    }
}