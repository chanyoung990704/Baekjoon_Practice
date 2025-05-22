import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        Deque<int[]> dq = new ArrayDeque<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0 ; i < input.length ; i++) {
            dq.offer(new int[]{i+1, Integer.valueOf(input[i])});
        }

        List<Integer> results = new ArrayList<>();
        int move = dq.peekFirst()[1];
        results.add(dq.pollFirst()[0]);

        while (!dq.isEmpty()) {
            if (move > 0) {
                while (move > 1) {
                    dq.offerLast(dq.pollFirst());
                    move--;
                }
            }else{
                while (move < 0) {
                    dq.offerFirst(dq.pollLast());
                    move++;
                }
            }

            move = dq.peekFirst()[1];
            results.add(dq.pollFirst()[0]);
        }

        System.out.println(results.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
