

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

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // 개수 n 타겟 K
             int[] nK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
             int n = nK[0];
             int K = nK[1];

             int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
             // 정렬
            Arrays.sort(nums);

            int lo = 0;
            int hi = nums.length - 1;

            int min = Integer.MAX_VALUE;
            int cnt = 0;

            while (lo < hi) {
                int sum = nums[lo] + nums[hi];

                int abs = Math.abs(sum - K);

                // 갱신
                if(min > abs){
                    min = abs;
                    cnt = 1;
                } else if (min == abs) {
                    cnt++;
                }

                if (sum < K) {
                    lo++;
                }else{
                    hi--;
                }
            }

            System.out.println(cnt);
        }
    }
}
