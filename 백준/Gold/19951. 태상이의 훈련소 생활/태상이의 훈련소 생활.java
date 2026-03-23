import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static int[] nums;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 숫자 배열
        nums = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();

        // M번 구간 구하기
        // 누적합 배열 필요
        int[] prefixSum = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            prefixSum[l-1] += v;
            prefixSum[r] += -v;
        }

        // 누적합 구하기
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        // 배열
        for (int i = 0; i < nums.length; i++) {
            nums[i] += prefixSum[i];
        }

        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
