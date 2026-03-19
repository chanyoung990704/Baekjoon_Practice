import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static List<int[]> items = new ArrayList<>();
    static List<Integer> bags = new ArrayList<>();

    static long ret = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items.add(new int[]{Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())}); // 무게, 가격
        }

        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]).reversed());

        // 가방 무게 낮은 거부터
        bags.sort(Comparator.naturalOrder());

        items.sort((a, b) -> {
            if (a != b) return Integer.compare(a[0], b[0]);  // 무게 오름차순
            return Integer.compare(b[1], a[1]);                    // 가격 내림차순
        });

        int idx = 0;
        for (int bag : bags) {
            // 현재 가방 무게보다 낮은 거 일단 다 넣기
            while (idx < items.size() && items.get(idx)[0] <= bag) {
                pq.add(items.get(idx++));
            }

            // 가장 가치 높은거 뽑기
            if (!pq.isEmpty()) {
                ret += pq.poll()[1];
            }
        }

        System.out.println(ret);
    }
}
