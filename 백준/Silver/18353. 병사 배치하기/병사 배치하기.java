import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> numArr = new ArrayList<>(
                        Arrays.stream(br.readLine().split(" "))
                              .map(Integer::valueOf)
                              .collect(Collectors.toList()));
        
        Collections.reverse(numArr);

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j < i ; j++){
                if(numArr.get(j) < numArr.get(i)){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Arrays.stream(dp)
                        .max().getAsInt();
        System.out.println(N - max);

        br.close();
    }
}