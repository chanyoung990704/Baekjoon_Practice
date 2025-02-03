import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int[] dp = new int[N + 1];
        int[] idx = new int[N + 1];

        for(int i = 0 ; i < list.size() ; i++){
            idx[list.get(i)] = i;
        }

        Arrays.fill(dp, 1);
        int maxLIS = 1;
        // 연속 LIS DP
        for(int i = 1 ; i < N ; i++) {
            if(idx[i] < idx[i + 1]){
                dp[i + 1] = dp[i] + 1;
            }
            maxLIS = Math.max(maxLIS, dp[i + 1]);
        }

        System.out.println(N - maxLIS);

    }
}

