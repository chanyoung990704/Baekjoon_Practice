
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });

        for(int i = 0; i < t; i++) {
            int cur = Integer.valueOf(br.readLine());
            if (cur != 0) {
                pq.offer(cur);
            }else{
                System.out.println(pq.isEmpty() ? 0 : pq.poll());
            }
        }

    }
}
