import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> nums = Arrays.stream(br.readLine().split(" "))
                                   .map(Integer::valueOf)
                                   .collect(Collectors.toList());

        List<Integer> ops = Arrays.stream(br.readLine().split(" "))
                                   .map(Integer::valueOf)
                                   .collect(Collectors.toList());                                   
        
        solve(ops.get(0), ops.get(1), ops.get(2), ops.get(3), nums.get(0), nums, 1);
        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    static void solve(int sum, int minus, int mul, int div, int total, List<Integer> nums, int idx){
        if(sum == 0 && minus == 0 && mul == 0 && div == 0){
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        int cur = nums.get(idx);

        if(sum > 0){
            solve(sum - 1, minus, mul, div, total + cur, nums, idx + 1);
        }

        if(minus > 0) {
            solve(sum, minus - 1, mul, div, total - cur, nums, idx + 1);
        }

        if(mul > 0) {
            solve(sum, minus, mul - 1, div, total * cur, nums, idx + 1);
        }

        if(div > 0) {
            if(total < 0) solve(sum, minus, mul, div - 1, (Math.abs(total) / cur) * -1, nums, idx + 1);
            else solve(sum, minus, mul, div - 1, total / cur, nums, idx + 1);
        }
    }
}