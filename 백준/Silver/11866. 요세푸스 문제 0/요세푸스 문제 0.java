import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NK.get(0);
        int K = NK.get(1);


        Deque<Integer> dq = new ArrayDeque<>(
            IntStream.range(1, N + 1).mapToObj(Integer::valueOf)
            .collect(Collectors.toList())
        );

        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        while (!dq.isEmpty()) {
            // 꺼낸다
            int cur = dq.pollFirst();
            cnt++;

            // K번이면 다시 집어넣지 않는다
            if(cnt == K){
                cnt = 0;
                res.add(cur);
                continue;
            }
            dq.offerLast(cur);
        }

        StringBuilder sb = new StringBuilder("<");
        for(int i = 0 ; i < res.size() ; i++){
            if(i != res.size() - 1){
                sb.append(res.get(i) + ", ");
            }else{
                sb.append(res.get(i) + ">");
            }
        }
        
        System.out.println(sb.toString());
    }
}
