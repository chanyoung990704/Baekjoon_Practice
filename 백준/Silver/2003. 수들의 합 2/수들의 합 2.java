import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf).toArray();

        int N = NM[0];
        int M = NM[1];

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf).toArray();

        int lo = 0;
        int hi = 0;

        int sum = 0;
        int cnt= 0;

        while (hi < nums.length) {
            sum += nums[hi];

            // target
            while (lo < nums.length && sum >= M) {
                if(sum == M) {
                    cnt++;
                }
                sum -= nums[lo];
                lo++;
            }

            hi++;
        }

        System.out.println(cnt);

    }
}
