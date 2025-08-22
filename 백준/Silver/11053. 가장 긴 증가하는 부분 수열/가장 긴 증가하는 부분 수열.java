import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> nums = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);

        int cnt = getLIS(-1, nums, dp);
        System.out.println(--cnt);
    }

    private static int getLIS(int idx, List<Integer> nums, int[] dp) {

        if (dp[idx + 1] != -1) {
            return dp[idx + 1];
        }

        int ret = 1;
        for(int i = idx + 1 ; i < nums.size(); i++) {
            if (idx == -1 || nums.get(idx) < nums.get(i)) {
                ret = Math.max(ret, getLIS(i, nums, dp) + 1);
            }
        }

        return dp[idx + 1] = ret;
    }
}
