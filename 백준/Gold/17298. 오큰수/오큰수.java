import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Deque<Integer> dq = new ArrayDeque<>();
        int[] results = new int[N];

        // 맨 뒤 초기화
        dq.offerLast(list.get(list.size()-1));
        results[N-1] = -1;

        for(int i = N-2; i >= 0; i--){
            // 현재 숫자
            int cur = list.get(i);

            while (!dq.isEmpty() && dq.peekLast() <= cur){
                dq.pollLast();
            }

            // 결과 넣기
            // 비었으면
            if(dq.isEmpty()){
                results[i] = -1;
            }else{
                results[i] = dq.peekLast();
            }

            dq.offerLast(cur);
        }

        System.out.println(Arrays.stream(results).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
