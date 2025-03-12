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

        long cnt = 0;
        for(int i = 0 ; i < nums.length - 2; i++){
            for(int j = i + 1 ; j < nums.length - 1; j++){
                int sum = nums[i] + nums[j];

                // 하한 찾기
                int lowerIdx = lowerBinarySearch(nums, sum * -1, j + 1);
                if(lowerIdx == -1){
                    continue;
                }
                int upperIdx = upperBinarySearch(nums, sum * -1, j + 1);
                cnt += upperIdx - lowerIdx + 1;
            }
        }

        System.out.println(cnt);
    }

    private static int upperBinarySearch(int[] nums, int target, int lo) {
        int hi = nums.length - 1;
        int ret = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > target) {
                hi = mid - 1;
            }else{
                ret = mid;
                lo = mid + 1;
            }
        }

        if (ret == -1 || nums[ret] != target) {
            return -1;
        }
        return ret;
    }

    private static int lowerBinarySearch(int[] nums, int target, int lo) {
        int hi = nums.length - 1;
        int ret = nums.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] >= target) {
                ret = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        // 타깃이 없는 경우
        if (ret == nums.length || nums[ret] != target) {
            return -1;
        }
        return ret;
    }
}
