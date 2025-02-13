import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int n = Integer.valueOf(br.readLine());
        int m = Integer.valueOf(br.readLine());

        List<List<List<Integer>>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m ; i++){
            List<Integer> cur = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            int f = cur.get(0);
            int t = cur.get(1);
            int d = cur.get(2);
            graph.get(f).add(List.of(t, d));
        }

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());        

        int start = list.get(0);
        int end = list.get(1);

        // 다익스트라
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
            Comparator.comparing((List<Integer> cur) -> cur.get(1)));

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1]; // 경로 저장
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        parent[start] = start;
        pq.offer(List.of(start, 0));

        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            int idx = cur.get(0);
            int cost = cur.get(1);
            if(dist[idx] < cost){
                continue;
            }

            for(List<Integer> next : graph.get(idx)){
                int nextIdx = next.get(0);
                int nextCost = cost + next.get(1);
                if(dist[nextIdx] > nextCost){
                    dist[nextIdx] = nextCost;
                    parent[nextIdx] = idx;
                    pq.offer(List.of(nextIdx, nextCost));
                }
            }
        }

        // 경로 찾기
        Deque<Integer> route = new ArrayDeque<>();
        int idx = end;
        while (parent[idx] != idx) {
            route.offerFirst(idx);
            idx = parent[idx];
        }
        route.offerFirst(start);

        // 출력
        System.out.println(dist[end]);
        System.out.println(route.size());
        System.out.println(
            route.stream().map(String::valueOf)
            .collect(Collectors.joining(" "))
        );

    }
}


