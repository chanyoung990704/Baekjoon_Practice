import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        List<int[]> schedule = new ArrayList<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            schedule.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 최소의 강의실 사용
        // 시작점 정렬
        schedule.sort(Comparator.comparing((int[] a) -> a[0])
                .thenComparing(a -> a[1]));

        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] s : schedule) {
            int start = s[0], end = s[1];
            // 이미 시작된 스케줄이 끝난 경우
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);
            cnt = Math.max(cnt, pq.size());
        }

        System.out.println(cnt);

    }
}
