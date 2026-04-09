import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100001]; 
        q.offer(new int[]{N, 0});

        while (!q.isEmpty()) {
            int[] p = q.pollFirst();
            int cur = p[0], time = p[1];

            if (cur == K) {
                System.out.println(time);
                return;
            }
            if (cur < 0 || cur > 100000 || visited[cur]) continue;
            visited[cur] = true;

            if (cur * 2 <= 100000) q.addFirst(new int[]{cur * 2, time});
            if (cur + 1 <= 100000) q.addLast(new int[]{cur + 1, time + 1});
            if (cur - 1 >= 0) q.addLast(new int[]{cur - 1, time + 1});
        }
    }
}