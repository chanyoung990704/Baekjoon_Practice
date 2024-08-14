import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        List<int[]> days = new ArrayList<>();

        days.add(new int[]{-1, -1}); // 더미값
        for(int i = 1 ; i <= N ; i++) {
            int[] cur = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::valueOf).toArray();
            days.add(cur);
        }

        int[] dp = new int[N + 2]; 
        int max = 0;
        for(int i = N ; i > 0 ; i--){
            int[] cur = days.get(i);

            // 오늘을 포함할 수 있는 경우
            if(i + cur[0] <= N + 1) { 
                max = Math.max(max, cur[1] + dp[i + cur[0]]); 
            }

            dp[i] = max;
        }

        System.out.println(dp[1]); 

        br.close();
    }
}