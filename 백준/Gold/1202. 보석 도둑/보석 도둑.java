import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NK.get(0);
        int K = NK.get(1);

        List<List<Integer>> jewels = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            jewels.add(
                Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList()));
        }

        List<Integer> bags = new ArrayList<>();
        for(int i = 0 ; i < K ; i++){
            bags.add(Integer.valueOf(br.readLine()));
        }

        // 무게 오름차순 정렬
        jewels.sort(Comparator.comparing((List<Integer> list) -> list.get(0)));
        
        // 가방 정렬
        bags.sort(Comparator.naturalOrder());

        // 가치 최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int jewelIdx = 0;
        long total = 0;

        for(int bag : bags){
            
            // 현재 가방에 들어갈 수 있는 보석 다 담기
            while (jewelIdx < jewels.size() && jewels.get(jewelIdx).get(0) <= bag) {
                pq.offer(jewels.get(jewelIdx).get(1));
                jewelIdx++;
            }

            if(!pq.isEmpty()){
                total += pq.poll();
            }
        }
        System.out.println(total);

    }
}
