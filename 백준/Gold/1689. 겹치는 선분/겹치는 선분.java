import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int N = Integer.valueOf(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList()));
        }

        // 시작 시간 오름차순 정렬
        list.sort(Comparator.comparing((List<Integer> l) -> l.get(0)));

        // 종료시간 최소 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;
        int cnt = 0;

        for(int i = 0 ; i < list.size() ; i++) {
            int start = list.get(i).get(0);
            int end = list.get(i).get(1);

            // 현재시각보다 이전 종료시각 제외
            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
                cnt--;
            }

            // 현재시각 삽입
            cnt++;
            max = Math.max(max, cnt);
            pq.offer(end);
        }

        System.out.println(max);
    }
}

