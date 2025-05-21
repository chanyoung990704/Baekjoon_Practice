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

        int lo = Arrays.stream(nums).max().getAsInt();
        int hi = Arrays.stream(nums).sum();
        int ret = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // cd 개수 구하기
            int sum = 0;
            int cnt = 1;

            for(int i = 0 ; i < nums.length ; i++) {
                int num = nums[i];

                if(sum + num > mid){
                    cnt++;
                    sum = num;
                }else{
                    sum += num;
                }
            }

            // 길이를 늘려야 하는 경우
            if (cnt > M) {
                lo = mid + 1;
            }else {
                ret = mid;
                hi = mid - 1;
            }
        }

        System.out.println(ret);

        }

}
