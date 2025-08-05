import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.valueOf(br.readLine());
        int len = s.length();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        boolean[] dp = new boolean[len];
        for(int i = len-1 ; i >= 0 ; i--) {
            String sub1 = s.substring(i);
            // 부분 문자열인지 확인
            if(set.contains(sub1)) {
                dp[i] = true;
                continue;
            }

            // 구간을 나누어 부분 문자열인지 확인
            for(int j = i + 1; j < len; j++) {
                if(dp[j]){
                    String sub2 = s.substring(i, j);
                    if(set.contains(sub2)) {
                        dp[i] = true;
                    }
                }
            }
        }

        System.out.println(dp[0] ? 1 : 0);
    }
}
