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

        int time = 0;
        Deque<List<Integer>> dq = new ArrayDeque<>(); // 이전 과제 저장할 스택
        int score = 0;

        while(time < N){
            time++;
            // 과제 서칭
            List<Integer> curTimeWork = list.get(time - 1);
            // 과제가 들어오는 시점
            if(curTimeWork.get(0) == 1){
                // 과제 스택에 삽입
                dq.offerLast(curTimeWork);
            }

            // 과제 진행
            if(!dq.isEmpty()){
                dq.peekLast().set(2, dq.peekLast().get(2) - 1);
            }

            // 과제가 끝난 경우
            if(!dq.isEmpty() && dq.peekLast().get(2) == 0){
                score += dq.pollLast().get(1);
            }
        }

        System.out.println(score);
    }
}


