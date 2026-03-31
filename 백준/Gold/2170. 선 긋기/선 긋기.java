import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int[][] idx = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
            idx[i] = new int[]{start, end};
        }

        // 시작점 기준 정렬
        Arrays.sort(idx, (a, b) -> a[0] - b[0]);

        int left = idx[0][0], right = idx[0][1];
        int sum = 0;
        for (int i = 1; i < N; i++) {
            // 구간 안일 경우
            if (right >= idx[i][0]) {
                right = Math.max(right, idx[i][1]);
            }
            else{
                // 이전 값 계산
                sum += right - left;
                left = idx[i][0];
                right = idx[i][1];
            }
        }

        sum += right - left;

        System.out.println(sum);
    }
}
