import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> nwL = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int n = nwL.get(0);
        int w = nwL.get(1);
        int L = nwL.get(2);

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int time = 0;
        int bridgeWeight = 0;
        Deque<List<Integer>> dq = new ArrayDeque<>(); // 트럭 무게, 들어온 시간

        for(int i = 0 ; i < list.size() || !dq.isEmpty();){
            // 시간이 지나서 빠지는 것
            if(!dq.isEmpty() && dq.peekFirst().get(1) + w == time){
                bridgeWeight -= dq.pollFirst().get(0); 
            }

            // 현재 큐에 넣을 수 있는 경우
            if(i < list.size() && dq.size() < w && bridgeWeight + list.get(i) <= L){
                dq.offerLast(List.of(list.get(i), time));
                bridgeWeight += list.get(i);
                i++;
            }

            time++;
        }

        System.out.println(time);
    }
}

