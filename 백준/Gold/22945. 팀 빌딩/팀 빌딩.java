import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int N = Integer.valueOf(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        int lo = 0;
        int hi = nums.length - 1;
        int max = 0;
        while (lo < hi) {
            int len = (hi - lo) + 1;
            if(len < 2){
                break;
            }

            int val = Math.min(nums[lo], nums[hi]) * (len - 2);
            max = Math.max(max, val);

            if(nums[lo] < nums[hi]){
                lo++;
            }else{
                hi--;
            }
        }

        System.out.println(max);
    }
}



