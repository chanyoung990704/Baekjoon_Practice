import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            list.add(Integer.valueOf(br.readLine()));
        }

        int[] dp = new int[N + 1];

        list.add(0, -1); // 더미값
        dp[1] = list.get(1);
        if(N > 1){
            dp[2] = list.get(1) + list.get(2);
        }

        for(int i = 3 ; i <= N ; i++){
            // 현재를 포함하며 연속 2개
            int noCur = list.get(i) + list.get(i - 1) + dp[i - 3];
            // 현재 포함하지 않고 최적의 값과 비교
            int max = Math.max(dp[i-1], noCur);
            // 현재 포함하고, 연속이 안되게 2개 전의 최적 값과 비교
            max = Math.max(max, dp[i - 2] + list.get(i));
            dp[i] = max;
        }

        System.out.println(dp[N]);

    }
}
