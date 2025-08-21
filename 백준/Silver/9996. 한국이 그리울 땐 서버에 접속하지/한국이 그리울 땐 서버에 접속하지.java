import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        String pattern = br.readLine();

        while (N-- > 0) {
            String str = br.readLine();

            int[][] dp =  new int[pattern.length() + 1][str.length() + 1];
            for(int i = 0 ; i < dp.length ; i++) {
                Arrays.fill(dp[i], -1);
            }

            if (solve(pattern, str, 0, 0, dp) == 1) {
                System.out.println("DA");
            }else{
                System.out.println("NE");
            }
        }
    }

    private static int solve(String pattern, String str, int pIdx, int sIdx, int[][] dp) {
        if (dp[pIdx][sIdx] != -1) {
            return dp[pIdx][sIdx];
        }

        while (pIdx < pattern.length() && sIdx < str.length() && (str.charAt(sIdx) == '?' || str.charAt(sIdx) == pattern.charAt(pIdx))) {
            pIdx++;
            sIdx++;
        }

        if(pIdx == pattern.length()){
            if(sIdx == str.length()){
                return dp[pIdx][sIdx] = 1;
            }else{
                return dp[pIdx][sIdx] = 0;
            }
        }

        if (pattern.charAt(pIdx) == '*') {
            for(int i = 0 ; sIdx + i <= str.length(); i++){
                if (solve(pattern, str, pIdx + 1, sIdx + i, dp) == 1) {
                    return dp[pIdx][sIdx] = 1;
                }
            }
        }

        return dp[pIdx][sIdx] = 0;
    }
}
