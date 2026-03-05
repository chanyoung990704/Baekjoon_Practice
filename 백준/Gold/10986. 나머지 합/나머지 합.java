import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합
        long[] prefixSum = new long[N+1];
        prefixSum[0] = 0L;
        for(int i = 0 ; i < N ; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        // 누적합 배열 각각 모듈러 구해서 카운팅
        long[] count = new long[M];
        Arrays.fill(count, 0L);
        count[0] = 1;

        long ans = 0;
        for(int i = 1 ; i <= N ; i++){
            int m = (int)(prefixSum[i] % M);
            ans += count[m];
            count[m] += 1;
        }

        System.out.println(ans);
    } 
}
