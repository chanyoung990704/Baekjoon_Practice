import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int[] dp = new int[list.size()];

        for(int i = 0 ; i < list.size() ; i++){
            dp[i] = list.get(i);
        }

        int max = dp[0];
        for(int i = 1 ; i < list.size() ; i++){
            for(int j = 0 ; j < i ; j++) {
                if(list.get(i) > list.get(j)){
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i));
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
