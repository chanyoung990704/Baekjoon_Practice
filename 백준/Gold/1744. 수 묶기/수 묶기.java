import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = new ArrayList<>();

        int cnt = 0; // 음수 개수
        for(int i = 0 ; i < N ; i++){
            int n = Integer.valueOf(br.readLine());
            if(n < 0){
                cnt++;
            }
            list.add(n);
        }

        // 음수 1개와 0이 있는 경우
        if(cnt == 1 && list.stream().anyMatch(i -> i == 0)){
            // 음수와 0 삭제
            list = list.stream().filter(j -> j > 0)
            .collect(Collectors.toList());
        }

        // 양수 리스트
        List<Integer> positive = list.stream().filter(i -> i > 0)
        .collect(Collectors.toList());

        // 음수 리스트
        List<Integer> negative = list.stream().filter(i -> i <= 0)
        .collect(Collectors.toList());

        int total = 0;

        // 양수 계산
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0 ; i < positive.size() ; i++){
            pq.offer(positive.get(i));
        }
        while (pq.size() > 1) {
           int f = pq.poll();
           int s = pq.poll();
           if(f == 1 || s == 1){
                total += (f + s);
           } else{
                total += (f * s);
           }
        }

        if(!pq.isEmpty()){
            total += pq.poll();
        }

        // 음수 계산
        pq = new PriorityQueue<>();
        for(int i = 0 ; i < negative.size() ; i++){
            pq.offer(negative.get(i));
        }
        while (pq.size() > 1) {
            int f = pq.poll();
            int s = pq.poll();
            // 0 이있으면 곱하기
            if(f == 0 || s == 0){
                continue;
            }else{
                total += (f * s);
            }
        }

        if(!pq.isEmpty()){
            total += pq.poll();
        }

        System.out.println(total);

    }
}
