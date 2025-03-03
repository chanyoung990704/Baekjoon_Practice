import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int[] SN = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        int S = SN[0];
        int N = SN[1];

        int[] nums = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        int lo = 0;
        int hi = 0;
        int odd = 0; // 홀수 개수
        int even = 0;
        int max = 0;
        while (hi < nums.length) {
            // 홀수 개수가 적으면 hi담기
            if(odd <= N){
                if(nums[hi] % 2 == 1){
                    odd++;
                }else{
                    even++;
                }
                hi++;
                max = Math.max(max, even);
            }else{
                if(nums[lo] % 2 == 1){
                    odd--;
                }else{
                    even--;
                }
                lo++;
            }
        }

        System.out.println(max);
    }
}


