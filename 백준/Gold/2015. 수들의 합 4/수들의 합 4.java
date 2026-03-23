import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, K;

    static int[] nums;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합
        int[] prefixSum = new int[N + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // 저장을 위한 해시맵
        Map<Integer, Integer> map = new HashMap<>();
        long ret = 0;
        for (int num : prefixSum) {
            int cur = num - K;
            ret += map.containsKey(cur) ? map.get(cur) : 0;
            map.merge(num, 1, Integer::sum);
        }

        System.out.println(ret);
    }
}
