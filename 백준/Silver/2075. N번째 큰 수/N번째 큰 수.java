
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.time.*;
import java.util.regex.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크기 N
        int N = Integer.valueOf(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < N; i++) {
            // N배열
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < arr.length; j++) {
                pq.offer(arr[j]);
            }
        }

        // N 번째 수
        while (N > 1) {
            pq.poll();
            N--;
        }

        System.out.println(pq.peek());
    }
}
