import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N,S;
    static int[] nums;

    static long ret = 987654321;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        // 슬라이딩 윈도우
        int lo = 0, hi = 0;
        long total = 0;

        while (hi < N) {
            // 처음에 값을 넣는다
            total += nums[hi];

            // S이상이면 lo를 줄인다
            while (lo <= hi && total >= S) {
                // 길이 갱신
                ret = Math.min(ret, hi - lo + 1);
                total -= nums[lo];
                lo++;
            }

            hi++;
        }

        System.out.println(ret == 987654321 ? 0 : ret);
    }
}