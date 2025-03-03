import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int[] NS = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        int N = NS[0];
        int S = NS[1];

        int[] nums = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        int lo = 0;
        int hi = 0;

        int minLen = Integer.MAX_VALUE;
        int total = 0;
        while (hi < nums.length) {
            total += nums[hi];

            while (total >= S) {
                minLen = Math.min(minLen, hi - lo + 1);
                total -= nums[lo++];
            }

            hi++;
        }

        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);

    }
}



