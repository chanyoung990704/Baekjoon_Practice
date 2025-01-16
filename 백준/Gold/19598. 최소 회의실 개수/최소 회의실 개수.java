import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        List<List<Integer>> schedule = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            schedule.add(
                Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList())
            );
        }

        schedule.sort(Comparator.comparing((List<Integer> list) -> list.get(0)));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(schedule.get(0).get(1));
        schedule.remove(0);

        while (!schedule.isEmpty()) {
            if(pq.peek() <= schedule.get(0).get(0)){
                pq.poll();
            }
            pq.offer(schedule.get(0).get(1));
            schedule.remove(0);
        }

        System.out.println(pq.size());
    }
}
