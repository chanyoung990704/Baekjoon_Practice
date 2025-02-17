import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
    
        // N과 M 입력 받기
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 수열 입력 받기
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 수열 정렬
        Arrays.sort(nums);

        int left = 0;
        int right = 0;
        int minDiff = Integer.MAX_VALUE;

        // 투 포인터로 차이가 M 이상인 최소값 찾기
        while(right < N) {
            int diff = nums[right] - nums[left];
            
            if(diff >= M) {
                minDiff = Math.min(minDiff, diff);
                left++;
            } else {
                right++;
            }
            
            // left가 right를 넘어가면 right 위치에서 다시 시작
            if(left == right) {
                right++;
            }
        }

        System.out.println(minDiff);
    }
}
