import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int n, m;

    static int[] tree, pos;
    static int lastIdx;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // 영화 숫자만큼 세그먼트 트리 만들기
            int h = (int) Math.ceil(Math.log(n + m) / Math.log(2));
            lastIdx = 1 << h;
            tree = new int[2 * lastIdx];
            pos = new int[n + 1];


            // 트리 만들기
            for (int i = 1; i <= n; i++) {
                int targetIdx = m + i;
                pos[i] = targetIdx;
                update(targetIdx, 1);
            }

            // 꺼낼 영화
            st = new StringTokenizer(br.readLine());
            int currentTop = m;

            for (int i = 0; i < m; i++) {
                int movie = Integer.parseInt(st.nextToken());
                int moviePos = pos[movie];

                // 영화 개수 구하기
                int cnt = query(1, moviePos - 1);
                sb.append(cnt).append(" ");

                // 영화 꺼내기
                update(moviePos, 0);
                pos[movie] = currentTop;
                update(currentTop, 1);
                currentTop--;
            }


            System.out.println(sb);
            sb.setLength(0);
        }

    }

    private static int query(int start, int end) {
        int l = lastIdx + start - 1;
        int r = lastIdx + end - 1;
        int sum = 0;

        while (l <= r) {
            if (l % 2 == 1) {
                sum += tree[l++];
            }
            if (r % 2 == 0) {
                sum += tree[r--];
            }

            l /= 2;
            r /= 2;
        }

        return sum;
    }

    private static void update(int targetIdx, int val) {
        int i = lastIdx + targetIdx - 1;
        tree[i] = val;
        while (i > 1) {
            i /= 2;
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }
}
