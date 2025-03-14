
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
        // ?
        for (int i = 0; i < M; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 1 ; j < input.length - 1; j++) {
                graph.computeIfAbsent(input[j], k -> new ArrayList<>()).add(input[j + 1]);
                indegree[input[j + 1]]++;
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1;  i <= N; i++) {
            if(indegree[i] == 0){
                dq.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int cur = dq.pollFirst();
                res.add(cur);
                // 연결끊기
                if(graph.containsKey(cur)){
                    // 다음
                    for (int next : graph.get(cur)) {
                        indegree[next]--;
                        if(indegree[next] == 0){
                            dq.offer(next);
                        }
                    }
                }
            }
        }

        if(res.size()  < N){
            System.out.println(0);
        }else{
            for (int n : res) {
                System.out.println(n);
            }
        }

    }
}
