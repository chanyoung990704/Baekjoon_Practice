
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NX = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NX[0];
        int X = NX[1];

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lo = 0;
        int hi = 0;
        int cnt = 0;
        int sum = 0;
        int max = 0;

        while (hi < nums.length) {
            sum += nums[hi];
            while (hi - lo + 1 >= X) {
                if (sum == max) {
                    cnt++;
                }else if(sum > max){
                    cnt = 1;
                    max = sum;
                }
                sum -= nums[lo];
                lo++;
            }
            hi++;
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(cnt);
    }
}
