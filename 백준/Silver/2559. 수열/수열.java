import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] nums;

    static int max;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();

        // 슬라이딩 윈도우
        // 초기값
        int sum = IntStream.range(0, K).map(i -> nums[i]).sum();
        max = sum;

        int lo = 1, hi = K;
        while (hi < N) {
            // 이전 lo 감소
            sum -= nums[lo-1];
            // hi증가
            sum+= nums[hi];

            max = Math.max(max, sum);
            lo++;
            hi++;
        }

        System.out.println(max);

    }
}
