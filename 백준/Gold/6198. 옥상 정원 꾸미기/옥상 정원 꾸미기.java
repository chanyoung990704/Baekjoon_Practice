import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 스택 , 뒤부터 , 탑보다 크면 푸시 작으면 기존거 정리
        Stack<Integer> stack = new Stack<>();
        long[] cnt = new long[N];

        for (int i = 0 ; i < N ; i++) {
            // 기존 거 정리해야 한다면
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                int p = stack.pop();
                cnt[p] = i - p - 1;
            }

            // 스택에 삽입
            stack.add(i);
        }


        while (!stack.isEmpty()) {
            int p = stack.pop();
            cnt[p] = (N - 1) - p;
        }

        long total = 0;
        for (long val : cnt) total += val;
        System.out.println(total);
    }
}
