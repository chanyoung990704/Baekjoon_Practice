

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = NK[0];
        int K = NK[1];
        
        String nums = br.readLine();
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(char c : nums.toCharArray()) {
            int n = c - '0';
            // 현재보다 작은 거 있으면 삭제
            while (!dq.isEmpty() && K > 0 && dq.peekLast() < n){
                K--;
                dq.pollLast();
            }
            dq.offerLast(n);
        }

        while (K > 0) {
            K--;
            dq.pollLast();
        }

        System.out.println(dq.stream().map(String::valueOf).collect(Collectors.joining()));
    }
}
