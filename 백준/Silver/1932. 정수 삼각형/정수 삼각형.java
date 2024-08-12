import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static long[] dp;
    static int[] numArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.valueOf(br.readLine());
        int total = IntStream.range(1, n + 1).sum();
        dp = new long[total + 1];
        numArr = new int[total + 1];

        int idx = 1;
        for(int i = 0 ; i < n ; i++){
            for(int num : 
            Arrays.stream(br.readLine().split(" "))
           .mapToInt(Integer::valueOf)
           .toArray()) numArr[idx++] = num;
        }
        Arrays.fill(dp, -1);

        //DP
        System.out.println(solveDp(1, 1, n));

        br.close();
    }


    static long solveDp(int cur, int size, int n){
        if(size > n) return 0;

        if(dp[cur] != -1) return dp[cur];

        long max = 0;
        
        // 왼쪽
        max = Math.max(max, solveDp(cur + size, size + 1, n));
        // 오른쪽
        max = Math.max(max, solveDp(cur + size + 1, size + 1, n));

        dp[cur] = numArr[cur] + max;
        return dp[cur];
    }
    
}