
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            res.add(cur);

            if (graph.containsKey(cur)) {
                // 다음 연결 끊기
                for(int next : graph.get(cur)) {
                    indegree[next]--;
                    if(indegree[next] == 0){
                        pq.offer(next);
                    }
                }
            }
        }

        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }
}
