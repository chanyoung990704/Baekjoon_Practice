import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> NK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NK.get(0);
        int K = NK.get(1);

        List<Integer> nums = Arrays.stream(br.readLine().split(""))
        .map(Integer::valueOf).collect(Collectors.toList());

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0 ; i < nums.size() ; i++){
            int cur = nums.get(i);

            // 제일 높은 자릿수에 큰 숫자가 위치하게
            while (!dq.isEmpty() && K > 0 && dq.peekLast() < cur) {
                dq.pollLast();
                K--;
            }
            dq.add(cur);
        }

        while (K > 0) {
            dq.pollLast();
            K--;
        }

        System.out.println(dq.stream().map(String::valueOf)
        .collect(Collectors.joining()));
    }
}
