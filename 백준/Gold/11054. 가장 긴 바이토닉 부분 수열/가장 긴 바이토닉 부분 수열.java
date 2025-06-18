import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] result = new int[N];
        Arrays.fill(result, 1);
        for (int i = 1; i < N; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, result[j]);
                }
            }
            if(max != -1) {
                result[i] += max;
            }
        }

        // 뒤집어서 LIS
        int[] revNums = new int[N];
        for(int i = 0; i < N; i++) {
            revNums[N - i - 1] = nums[i];
        }
        int[] revResult = new int[N];
        Arrays.fill(revResult, 1);

        for(int i = 1; i < N; i++) {
            int max = -1;
            for(int j = 0; j < i; j++) {
                if(revNums[i] > revNums[j]) {
                    max = Math.max(max, revResult[j]);
                }
            }
            if(max != -1) {
                revResult[i] += max;
            }
        }

        int len = 1;
        for(int i = 0; i < N; i++) {
            int revIdx = N - i - 1;
            int curLen = result[i] + revResult[revIdx] - 1;
            if(curLen > len) {
                len = curLen;
            }
        }

        System.out.println(len);
    }
}
