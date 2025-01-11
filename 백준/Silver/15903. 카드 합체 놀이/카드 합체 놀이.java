import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nm = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int n = nm.get(0);
        int m = nm.get(1);

        List<Long> list = Arrays.stream(br.readLine().split(" "))
        .map(Long::valueOf).collect(Collectors.toList());

        PriorityQueue<Long> pq = new PriorityQueue<>(list);

        for(int i = 0 ; i < m ; i++){
            if(pq.size() < 2) break;

            Long x = pq.poll();
            Long y = pq.poll();
            Long sum = x + y;
            pq.offer(sum);
            pq.offer(sum);
        }

        Long total = 0L;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        System.out.println(total);
    
    }
}
