import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        
        List<Deque<Integer>> dqList = new ArrayList<>();
        for(int i = 0 ; i < 4 ; i++){
            dqList.add(new ArrayDeque<>());
        }

        // 로직
        for(int cur : list){
            boolean isPossible = false;

            // 가능한 스택 찾기
            for(Deque<Integer> dq : dqList){
                // 비어있거나 탑보다 큰 경우만 가능
                if(dq.isEmpty() || dq.peekLast() < cur){
                    dq.offerLast(cur);
                    isPossible = true;
                    break;
                }
            }

            if(!isPossible){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
