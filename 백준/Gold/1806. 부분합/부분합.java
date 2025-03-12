

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NS = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NS[0];
        int S = NS[1];

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lo = 0;
        int hi = 0;

        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi];

            while (sum >= S) {
                if(len > hi - lo + 1){
                    len = hi - lo + 1;
                }
                sum -= nums[lo++];
            }

            hi++;
        }

        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}
