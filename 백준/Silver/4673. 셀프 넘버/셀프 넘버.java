import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] nums = new boolean[10000 + 1];

        for(int i = 1; i <= 10000 ; i++) {
            int val = i;
            if(nums[val]) continue;
            while (generateNum(val) <= 10000) {
                val = generateNum(val);
                if(nums[val]) break;
                nums[val] = true;
            }
        }

        for(int i = 1 ; i <= 10000 ; i++)
            if(!nums[i]) System.out.println(i);
    }

    static int generateNum(int n){
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}