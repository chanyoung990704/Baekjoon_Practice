import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, L;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = new int[N];

        // 슬라이딩 윈도우 디큐
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            // 범위 확인
            if (!dq.isEmpty() && dq.peekFirst() <= i - L) {
                dq.pollFirst();
            }

            // 최솟값 확인
            while (!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            sb.append(arr[dq.peekFirst()]).append(" ");
        }

        System.out.println(sb);

    }
}
