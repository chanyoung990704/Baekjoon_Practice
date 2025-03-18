

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        // 투포인터
        int lo = 0;
        int hi = nums.length - 1;
        int cnt = 0;

        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if(sum < target) {
                lo++;
            }else if(sum > target) {
                hi--;
            }else{
                cnt++;
                hi--;
            }
        }
        System.out.println(cnt);
    }
}
