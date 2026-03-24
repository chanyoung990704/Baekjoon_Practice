import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, L;
    static int[][] idx;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        idx = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            idx[i][0] = start;
            idx[i][1] = end;
        }

        Arrays.sort(idx, (a, b) -> a[0] - b[0]);

        long lastIdx = 0;
        long total = 0;

        for (int[] i : idx) {
            int start = i[0], end = i[1];

            // 널빤지의 끝보다 시작지점이 더 멀리 있으면
            if (lastIdx < start) {
                lastIdx = start;
            }

            // lastIdx부터 덮기
            if (lastIdx < end) {
                long cnt = (end - lastIdx + L - 1) / L;
                lastIdx += cnt * L;
                total += cnt;
            }
        }

        System.out.println(total);
    }
}
