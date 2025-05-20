import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class Work {
        int d;
        int w;

        public Work(int[] arr) {
            this.d = arr[0];
            this.w = arr[1];
        }

        @Override
        public String toString() {
            return "Work{" +
                    "d=" + d +
                    ", w=" + w +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Work> works = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            works.add(new Work(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray()));
        }

        works.sort(Comparator.comparing((Work w) -> w.d));

        PriorityQueue<Work> pq = new PriorityQueue<>(Comparator.comparing((Work w) -> w.w));

        for(int i = 0 ; i < works.size() ; i++) {
            Work w = works.get(i);
            pq.offer(w);

            if (pq.size() > w.d) {
                pq.poll();
            }
        }

        int total = pq.stream().mapToInt(w -> w.w).sum();
        System.out.println(total);
    }
}
