

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

        int[] indegree = new int[N + 1]; // 진입차수

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            adj.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            indegree[b]++;
        }

        int[] res = new int[N + 1];
        int idx = 1;
        // 진입 차수 없는 것 고르기
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                dq.offerLast(i);
                res[i] = idx;
            }
        }

        while (!dq.isEmpty()) {
            idx++;
            int size = dq.size();
            // 연결 끊기
            for(int i = 0; i < size; i++) {
                int cur = dq.pollFirst();
                if(adj.containsKey(cur)) {
                    for (int child : adj.get(cur)) {
                        indegree[child]--;
                        if (indegree[child] == 0) {
                            dq.offerLast(child);
                            res[child] = idx;
                        }
                    }
                    adj.remove(cur);
                }
            }
        }

        System.out.println(IntStream.range(1, N + 1).map(i -> res[i])
                .mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
