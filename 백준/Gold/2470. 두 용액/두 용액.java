

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums.length - 1;

        int rlo = 0;
        int rhi = nums.length - 1;

        while (lo < hi) {
            int total = nums[lo] + nums[hi];
            int prev = nums[rlo] + nums[rhi];

            if(Math.abs(total - 0) < Math.abs(prev - 0)) {
                rlo = lo;
                rhi = hi;
            }

            if(total > 0){
                hi--;
            } else if (total < 0) {
                lo++;
            }else{
                break;
            }
        }

        System.out.println(nums[rlo] + " " + nums[rhi]);
    }
}
