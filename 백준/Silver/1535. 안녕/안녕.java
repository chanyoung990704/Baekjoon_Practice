

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> health = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        health.add(0);
        values.add(0);

        health.addAll(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        values.addAll(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));

        int[][] dp = new int[N + 1][100];

        for(int i = 1; i <= N; i++) {
            int h = health.get(i);
            int v = values.get(i);
            for(int j = 0; j < 100; j++) {
                if(j < h){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - h] + v);
                }
            }
        }

        System.out.println(dp[N][99]);
    }
}
