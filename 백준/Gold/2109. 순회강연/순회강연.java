import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int n = Integer.valueOf(br.readLine());

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < n;  i++){
            list.add(
                Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList())
            );
        }

        // 최소힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        list.sort(Comparator.comparing((List<Integer> l) -> l.get(1)));

        for(List<Integer> l :list){
            int day = l.get(1);
            pq.offer(l.get(0));
            
            // 가장 작은 것 빼기
            while (pq.size() > day) {
                pq.poll();
            }
        }

        int total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        System.out.println(total);
    }
}
