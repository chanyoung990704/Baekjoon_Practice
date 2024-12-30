import java.io.*;
import java.util.*;
import java.util.stream.*;

import javax.xml.crypto.Data;

import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf)
        .collect(Collectors.toList());

        int M = NM.get(1);
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf)
        .collect(Collectors.toList());

        PriorityQueue<Integer> pq = new PriorityQueue<>(list);


        while (!pq.isEmpty() && M >= pq.peek()) {
            pq.poll();
            M++;
        }


        System.out.println(M);

        br.close();


    }
}