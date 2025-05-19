import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(nums);
        PriorityQueue<Integer> distance = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length - 1; i++) {
            distance.add(nums[i + 1] - nums[i]);
        }

        int total = nums[nums.length - 1] - nums[0];
        int cur = 1;

        while (!distance.isEmpty() && cur < K) {
            total -= distance.poll();
            cur++;
        }

        System.out.println(total);
    }
}
