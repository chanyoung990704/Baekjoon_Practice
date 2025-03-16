
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> nums = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());

        Deque<int[]> dq = new ArrayDeque<>(); // 값, 인덱스
        int[] ret = new int[N];

        for(int i = 0; i < N; i++) {
            int cur = nums.get(i);

            // 현재보다 낮은 거 다 제거
            while (!dq.isEmpty() && cur > dq.peekLast()[0]) {
                dq.pollLast();
            }

            // 비어있으면
            if(dq.isEmpty()) {
                ret[i] = 0;
            }else{
                ret[i] = dq.peekLast()[1] + 1;
            }

            dq.offerLast(new int[]{nums.get(i), i});
        }

        System.out.println(Arrays.stream(ret).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

    }
}
