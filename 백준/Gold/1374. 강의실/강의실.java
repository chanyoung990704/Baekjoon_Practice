import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<List<Integer>> schedule = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            schedule.add(
                Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList())
            );
        }


        // 시작 시간이 빠른 순으로 정렬
        schedule.sort(Comparator.comparing((List<Integer> list) -> list.get(1)));

        // 종료 시간 최소 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        
        pq.offer(schedule.get(0).get(2));

        for(int i = 1 ; i < schedule.size() ; i++) {
            List<Integer> cur = schedule.get(i);
            // 현재 최소 시작 시간이 최소 종료시각보다 늦으면 큐에서 꺼내기
            if(cur.get(1) >= pq.peek()){
                pq.poll();
            }
            pq.offer(cur.get(2));
        }

        System.out.println(pq.size());
    }
}
