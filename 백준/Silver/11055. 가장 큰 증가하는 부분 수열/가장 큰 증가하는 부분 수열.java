import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                .toArray();

        int[] len = new int[nums.length];
        int[] sum = Arrays.copyOf(nums, nums.length);

        Arrays.fill(len, 1);


        for(int i = 1 ; i < nums.length ; i++){
            int rear = nums[i];
            for (int j = 0; j < i; j++) {
                int front = nums[j];
                if(front < rear){
                    len[i] = Math.max(len[i], len[j] + 1);
                    sum[i] = Math.max(sum[i], sum[j] + nums[i]);
                }
            }
        }

        int max = Arrays.stream(sum).max().getAsInt();
        System.out.println(max);

    }
}
