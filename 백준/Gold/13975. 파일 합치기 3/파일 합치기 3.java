import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while(T-- > 0) {
            int K = Integer.valueOf(br.readLine());
            List<Long> list = Arrays.stream(br.readLine().split(" "))
            .map(Long::valueOf).collect(Collectors.toList());

            PriorityQueue<Long> pq = new PriorityQueue<>(list);

            long total = 0;

            while (pq.size() > 1) {
                long sum = pq.poll() + pq.poll();
                total += sum;
                pq.offer(sum);
            }

            System.out.println(total);
            
        }

    }
}
