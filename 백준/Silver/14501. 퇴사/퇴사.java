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

        int[] dp = new int[N + 1];
        for(int i = N ; i > 0 ; i--){
            int[] cur = days.get(i);
            if(i + cur[0] - 1 <= N) {
                int nextDay = i + cur[0];
                int profit = cur[1] + (nextDay <= N ? dp[nextDay] : 0);
                dp[i] = Math.max(profit, (i < N ? dp[i+1] : 0));
            } else {
                dp[i] = (i < N ? dp[i+1] : 0);
            }
        }

        System.out.println(dp[1]);

        br.close();
    }
}