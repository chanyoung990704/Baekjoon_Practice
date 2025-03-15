
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int mod = 1000000000;

        long[][] dp = new long[N + 1][10]; // long 타입으로 변경

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                // 끝 자리가 0 이면
                if(j == 0){
                    dp[i][j] = dp[i - 1][1] % mod;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod; // 합산 후 mod 연산
                }
            }
        }

        long ret = 0;
        for (int i = 0; i < 10; i++) {
            ret = (ret + dp[N][i]) % mod; // 매 더하기마다 mod 연산
        }
        System.out.println(ret);
    }
}
