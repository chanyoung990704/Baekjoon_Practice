import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        if (M > 0) { // M이 0인 경우 처리
            set = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toSet());
        }

        // 가장 먼저 기본채널에서 타겟까지
        int ans = Math.abs(100 - N);

        // brute force
        for(int i = 0 ; i < 1000000 ; i++) {
            if(isPossible(i, set)){
                ans = Math.min(ans, solve(i, N));
            }
        }

        System.out.println(ans);
    }

    private static int solve(int i, int N) {
        String str = String.valueOf(i);
        return str.length() + Math.abs(i - N);
    }

    private static boolean isPossible(int i, Set<Integer> set) {
        // 0인 경우 특별 처리
        if (i == 0) {
            return !set.contains(0);
        }

        while(i > 0){
            if(set.contains(i % 10)){
                return false;
            }
            i /= 10;
        }

        return true;
    }
}
