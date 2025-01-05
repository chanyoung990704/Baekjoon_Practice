import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // 각 집 앞에 쌓인 눈의 양을 우선순위 큐에 추가
        for (String s : input) {
            pq.offer(Integer.parseInt(s));
        }

        int time = 0;

        // 눈 치우기 시작
        while (!pq.isEmpty()) {
            int first = pq.poll(); // 가장 많은 눈이 쌓인 집
            int second = 0; // 두 번째로 많은 눈이 쌓인 집

            if (!pq.isEmpty()) {
                second = pq.poll();
            }

            // 두 집에서 동시에 치울 수 있는 만큼 치움
            if (first > 0 && second > 0) {
                time++;
                first--;
                second--;
            } else if (first > 0) { // 남은 한 집만 처리
                time += first;
                first = 0;
            }

            // 치운 후 남은 양 다시 큐에 삽입
            if (first > 0) pq.offer(first);
            if (second > 0) pq.offer(second);

            // 시간이 1440분 초과하면 중단
            if (time > 1440) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(time);
    }
}
