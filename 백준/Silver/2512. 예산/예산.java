import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());

        int sum = sumArr(nums);

        // 1번
        if (M >= sum) {
            System.out.println(Arrays.stream(nums).max().getAsInt());
            return;
        }

        // 배정 안되는 경우
        int lo = 1;
        int hi = 1000000000;
        int val = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midSum = sumArr(Arrays.stream(nums)
                    .map(i -> i > mid ? mid : i)
                    .toArray());

            if (midSum <= M) {
                val = mid;
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }

        System.out.println(val);
    }

    private static int sumArr(int[] nums) {
        return Arrays.stream(nums).sum();
    }


}
