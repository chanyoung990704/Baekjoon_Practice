import java.util.*;
import java.util.stream.*;

class Solution {

    class Work{
        int idx;
        int request;
        int time;
        
        Work(int idx, int request, int time){
            this.idx = idx;
            this.request = request;
            this.time = time;
        }
    }
    
    public int solution(int[][] jobs) {
        
        // 대기 큐 우선순위 소요시간 -> 요청 시각 -> 번호 작은거
        PriorityQueue<Work> pq =
            new PriorityQueue<>(Comparator.comparing((Work w) -> w.time)
                               .thenComparing((Work w) -> w.request)
                               .thenComparing((Work w) -> w.idx));
        
        // 작업 시작
        int time = 0;
        List<Work> list = new ArrayList<>();
        for(int i = 0 ; i < jobs.length ; i++){
            list.add(new Work(i, jobs[i][0], jobs[i][1]));
        }
        list.sort(Comparator.comparing((Work w) -> w.request));
        
        int idx = 0;
        int total = 0;
        while(idx < list.size() || !pq.isEmpty()){
            // 현재 시각 이전 작업
            while(idx < list.size() && list.get(idx).request <= time){
                pq.offer(list.get(idx));
                idx++;
            }
            
            // 작업 진행
            if(!pq.isEmpty()){
                Work cur = pq.poll();
                time += cur.time;
                total += time - cur.request;
            }else{
                time = list.get(idx).request;
            }

        }
        
        return total / list.size();
    }
}