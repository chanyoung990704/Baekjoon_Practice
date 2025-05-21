import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = NM[0];
        int M = NM[1];

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // dq 만들기
        Deque<Integer> dq = IntStream.range(1, N+1).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        int ret = 0;

        for (int target : nums) {
            if (dq.peekFirst() == target) {
                dq.pollFirst();
                continue;
            }

            int idx = 0;
            for(int n : dq) {
                if(n == target) {
                    break;
                }
                idx++;
            }

            int left = idx;
            int right = dq.size() - idx;

            if (left < right) {
                while (left-- > 0) {
                    dq.offerLast(dq.pollFirst());
                    ret++;
                }
            }else{
                while (right-- > 0) {
                    dq.offerFirst(dq.pollLast());
                    ret++;
                }
            }

            dq.pollFirst();

        }


        System.out.println(ret);

    }
}
