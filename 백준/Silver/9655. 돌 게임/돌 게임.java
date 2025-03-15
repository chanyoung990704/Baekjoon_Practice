
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        boolean[] dp = new boolean[1000 + 1]; // i 개 있을 때 선공인 사람이 이길 수 있는가

        dp[1] = true;
        dp[2] = false;
        dp[3] = true;

        if (N <= 3) {
            System.out.println(dp[N] ? "SK" : "CY");
            return;
        }

        for (int i = 4; i <= N; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 3];
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}
