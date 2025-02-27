import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> nmk = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int n = nmk.get(0);
        int m = nmk.get(1);
        int k = nmk.get(2);

        // 간선 입력
        List<List<List<Integer>>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m ; i++){
            List<Integer> ft = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            graph.get(ft.get(0)).add(List.of(ft.get(1), ft.get(2)));
        }

        // 다익스트라

        List<List<Integer>> dist = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            dist.add(new ArrayList<>());
        }
        dist.get(1).add(0);
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
            Comparator.comparing((List<Integer> l) -> l.get(1))
        );
        pq.offer(List.of(1, 0));

        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            int idx = cur.get(0);
            int cost = cur.get(1);

            // 이미 k개 이상의 경로가 있고, 현재 경로가 k번째보다 길면 무시
            if(dist.get(idx).size() >= k && dist.get(idx).get(k - 1) < cost){
                continue;
            }

            for(List<Integer> next : graph.get(idx)){
                int nextIdx = next.get(0);
                int nextCost = cost + next.get(1);

                if(dist.get(nextIdx).size() < k){
                    dist.get(nextIdx).add(nextCost);
                    Collections.sort(dist.get(nextIdx)); // 항상 정렬
                    pq.offer(List.of(nextIdx, nextCost));
                }
                else{
                    // 이미 k개가 있는 경우, 정렬 상태에서 확인
                    if(dist.get(nextIdx).get(k - 1) > nextCost){
                        dist.get(nextIdx).remove(k - 1);
                        dist.get(nextIdx).add(nextCost);
                        Collections.sort(dist.get(nextIdx)); // 항상 정렬
                        pq.offer(List.of(nextIdx, nextCost));
                    }
                }
            }
        }

        for(int i = 1 ; i <= n ; i++){
            if(dist.get(i).size() < k){
                System.out.println(-1);
            }else{
                System.out.println(dist.get(i).get(k - 1));
            }
        }

    }
}


