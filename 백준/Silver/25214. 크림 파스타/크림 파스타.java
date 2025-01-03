import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int max = 0;
        List<Integer> answer = new ArrayList<>();
        answer.add(0);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(list.get(0));

        for(int i = 1 ; i < list.size() ; i++){
            int cur = list.get(i);

            // 현재 - 이전 것들 중에 최소가 맥스보다 크면 갱신
            if(cur - pq.peek() > max){
                max = cur - pq.peek();
            }
            pq.offer(cur);
            answer.add(max);
        }

        String ans = answer.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(ans);

        br.close();
    }
}
