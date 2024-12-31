import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

        for(int i = 1; i <= list.size() ; i++)
            pq.offer(i + list.get(i - 1) + 1);

        System.out.println(pq.poll());

        br.close();


    }
}