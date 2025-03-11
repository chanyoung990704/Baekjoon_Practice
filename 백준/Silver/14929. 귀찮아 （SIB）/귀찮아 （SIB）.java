
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Long> prefixSum = new ArrayList<>();
        prefixSum.add(0L);
        for(int i = 1 ; i <= nums.length ; i++) {
            prefixSum.add(prefixSum.get(i - 1) + nums[i - 1]);
        }

        long total = 0;
        for(int i = 1 ; i <= nums.length ; i++) {
            int cur = nums[i - 1];
            total += cur * (prefixSum.get(prefixSum.size() - 1) - prefixSum.get(i));
        }

        System.out.println(total);
    }
}
