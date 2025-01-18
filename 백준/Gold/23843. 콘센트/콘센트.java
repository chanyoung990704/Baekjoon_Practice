import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        PriorityQueue<Integer> concent = new PriorityQueue<>();
        
        list.sort(Comparator.reverseOrder());

        int time = 0;
        while (!list.isEmpty() || !concent.isEmpty()) {
            // 큐가 채워지지 않았으면 일단 넣기
            while(concent.size() < M && !list.isEmpty()){
                concent.offer(list.get(0) + time);
                list.remove(0);
            }

            if(!concent.isEmpty()) { 
                // 가장 빨리 끝나는 충전 시간으로 이동
                time = concent.poll();
            }
        }

        System.out.println(time);
    }
}
