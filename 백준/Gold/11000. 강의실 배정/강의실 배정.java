import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        List<List<Integer>> list = new ArrayList<>(); // 시작, 끝
        for(int i = 0 ; i < T ; i++){
            list.add(
                Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList())
            );
        }

        // 시작 시간 오름차순
        list.sort(Comparator.comparing((List<Integer> l) -> l.get(0)));

        // 종료 시간 최소 힙
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(
            (List<Integer> l) -> l.get(1)
        ));

        // 더미 데이터
        pq.offer(List.of(-1, -1));
        for(int i = 0 ; i < list.size() ; i++){
            List<Integer> cur = list.get(i);
            if(!pq.isEmpty()){
                if(pq.peek().get(1) <= cur.get(0)){
                    pq.poll();
                }
                pq.offer(new ArrayList<>(cur));
            }
        }

        System.out.println(pq.size());

    }
}
