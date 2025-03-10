

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0];
        int K = NK[1];

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lo = 0;
        int hi = 0;
        int max = 0;
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(hi < nums.length) {
            map.put(nums[hi], map.getOrDefault(nums[hi], 0) + 1);
            max = Math.max(max, map.get(nums[hi]));

            while (max > K) {
                map.put(nums[lo], map.get(nums[lo]) - 1);
                if(map.get(nums[lo]) == 0) {
                    map.remove(nums[lo]);
                }
                lo++;
                max = map.get(nums[hi]);
            }
            len = Math.max(len, hi - lo + 1);
            hi++;
        }

        System.out.println(len);
    }

}
