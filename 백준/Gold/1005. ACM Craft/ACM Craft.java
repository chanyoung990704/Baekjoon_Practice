

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = NK[0];
            int K = NK[1];

            int[] times = new int[N + 1];
            int[] timeInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < timeInput.length; i++) {
                times[i + 1] = timeInput[i];
            }

            // 연결
            Map<Integer, List<Integer>> graph = new HashMap<>();
            int[] inDegree = new int[N + 1];
            for (int i = 0; i < K; i++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int a = input[0];
                int b = input[1];

                inDegree[b]++;
                graph.computeIfAbsent(a, x -> new ArrayList<>()).add(b);
            }


            // 타겟
            int target = Integer.valueOf(br.readLine());

            Deque<Integer> dq = new ArrayDeque<>();
            int[] dp = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    dq.offerLast(i);
                    dp[i] = times[i];
                }
            }

            // 위상정렬
            while(!dq.isEmpty()) {
                int size = dq.size();
                for(int i = 0 ; i < size ; i++) {
                    int cur = dq.pollFirst();
                    if(graph.containsKey(cur)) {
                        for(int next : graph.get(cur)) {
                            inDegree[next]--;
                            dp[next] = Math.max(dp[next], dp[cur] + times[next]);
                            if(inDegree[next] == 0) {
                                dq.offer(next);
                            }
                        }
                    }
                }
            }

            System.out.println(dp[target]);
        }
    }
}
