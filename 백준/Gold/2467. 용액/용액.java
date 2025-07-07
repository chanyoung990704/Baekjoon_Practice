import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        nums.sort(Comparator.naturalOrder());

        int lo = 0;
        int hi = N - 1;

        int leftResult = 0;
        int rightResult = N - 1;

        while (lo < hi){

            if(Math.abs(nums.get(lo) + nums.get(hi)) < Math.abs(nums.get(leftResult) + nums.get(rightResult))){
                leftResult = lo;
                rightResult = hi;
            }

            int sum = nums.get(lo) + nums.get(hi);
            if(sum < 0){
                lo++;
            }else{
                hi--;
            }

        }

        System.out.println(nums.get(leftResult) + " " + nums.get(rightResult));
    }
}
