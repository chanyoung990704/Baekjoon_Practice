import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Long> list = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            list.add(Long.valueOf(br.readLine()));
        }

        // 최소 힙
        PriorityQueue<Long> pq = new PriorityQueue<>(list);

        long cnt = 0;
        while (pq.size() > 1) {
            long cur = pq.poll() + pq.poll();
            cnt += cur;
            pq.offer(cur);
        }

        System.out.println(cnt);
    }
}
