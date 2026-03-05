import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for(int i = 0 ; i < N ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합
        int[] prefixSum = new int[N+1];
        Arrays.fill(prefixSum, 0);
        for(int i = 0 ; i < N; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        // 쿼리
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            System.out.println(prefixSum[r] - prefixSum[l-1]);
        }




    } 
}
