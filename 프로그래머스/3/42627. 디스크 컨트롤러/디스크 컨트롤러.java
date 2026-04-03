import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] jobs) {
        
        int[][] copied = new int[jobs.length][3];
        for(int i = 0 ; i < jobs.length ; i++){
            copied[i] = new int[]{jobs[i][0], jobs[i][1], i};
        }
        
        // 정렬
        Arrays.sort(copied, (a, b) -> a[0] - b[0]);
        
        // 작업 소요시간, 작업 요청 시각, 작업 번호
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>(Comparator.comparing((int[] a) -> a[0])
                               .thenComparing(a -> a[1])
                               .thenComparing(a -> a[2])); 
        
        int answer = 0;
        int count = 0, idx = 0, time = 0;
        while(count < jobs.length){
            // 현재 시각보다 같거나 짧은 거 큐에 넣기
            while(idx < jobs.length && copied[idx][0] <= time){
                pq.offer(new int[]{copied[idx][1], copied[idx][0], copied[idx][2]});
                idx++;
            }
            
            // 큐가 비었으면
            if(pq.isEmpty()){
                time = copied[idx][0];
            }else{
                int[] p = pq.poll();
                time += p[0];
                answer += (time - p[1]);
                count++;
            }
        }
        
        
        return answer / jobs.length;
    }
}