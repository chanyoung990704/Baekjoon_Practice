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

        // 종료시점 정렬
        schedule.sort(Comparator.comparing((int[] a) -> a[1])
                .thenComparing(a -> a[0]));

        int lastTime = Integer.MIN_VALUE;
        int answer = 0;
        for (int[] cur : schedule) {
            if (cur[0] >= lastTime) {
                answer++;
                lastTime = cur[1];
            }
        }

        System.out.println(answer);
    }
}
