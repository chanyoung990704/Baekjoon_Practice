import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int T = Integer.valueOf(br.readLine());

        while (T-- > 0) {
            List<Integer> VE = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());

            int V = VE.get(0);
            int E = VE.get(1);

            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0 ; i <= V ; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 0 ; i < E ; i++){
                List<Integer> uv = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
                int u = uv.get(0);
                int v = uv.get(1);
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            Map<Integer, Integer> visited = new HashMap<>();
            boolean isTrue = true;

            // 모든 정점에 대해 검사
            for(int start = 1; start <= V; start++) {
                if(!visited.containsKey(start)) {
                    Deque<List<Integer>> dq = new ArrayDeque<>();
                    dq.offer(List.of(start, 0));
                    visited.put(start, 0);

                    while (!dq.isEmpty() && isTrue) {
                        List<Integer> cur = dq.pollFirst();
                        int idx = cur.get(0);
                        int color = cur.get(1);
                        int nextColor = color == 0 ? 1 : 0;

                        for(int next : graph.get(idx)){
                            if(!visited.containsKey(next)){
                                visited.put(next, nextColor);
                                dq.offer(List.of(next, nextColor));
                            }else if(color == visited.get(next)){
                                isTrue = false;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(isTrue ? "YES" : "NO");
        }
    }
}

