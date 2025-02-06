import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> NKS = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NKS.get(0);
        int K = NKS.get(1);
        int S = NKS.get(2);

        PriorityQueue<List<Integer>> left = new PriorityQueue<>(
            Comparator.comparing((List<Integer> l) -> l.get(0))); // 왼쪽 거리 최소힙

        PriorityQueue<List<Integer>> right = new PriorityQueue<>(
            Comparator.comparing((List<Integer> l) -> l.get(0)).reversed()); // 오른쪽 거리 최대힙    
            
        // 입력
        for(int i = 0 ; i < N ; i++) {
            List<Integer> cur = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            // 왼쪽
            if(cur.get(0) < S){
                left.offer(new ArrayList<>(cur));
            }else{
                right.offer(new ArrayList<>(cur));
            }
        }

        int totalDist = 0;
        // 로직 진행
        while (!left.isEmpty() || !right.isEmpty()) {
            // 왼쪽 오른쪽 중 최대 거리 구하기
            int lefxDist = 0;
            int rightDist = 0;
            if(!left.isEmpty()){
                lefxDist = Math.abs(S - left.peek().get(0));
            }
            if(!right.isEmpty()){
                rightDist = Math.abs(S - right.peek().get(0));
            }

            int capacity = K;

            // 오른쪽이 멀리 있는 경우
            if(rightDist > lefxDist){
                if(!right.isEmpty()){
                    totalDist += Math.abs(right.peek().get(0) - S) * 2;
                }
                while (!right.isEmpty() && capacity > 0) {
                    List<Integer> rightCur = right.poll();
                    capacity -= rightCur.get(1);
                    if(capacity < 0){
                        right.offer(List.of(rightCur.get(0), Math.abs(capacity)));
                    }
                }
            }else{
                if(!left.isEmpty()){
                    totalDist += Math.abs(left.peek().get(0) - S) * 2;
                }
                while (!left.isEmpty() && capacity > 0) {
                    List<Integer> leftCur = left.poll();
                    capacity -= leftCur.get(1);
                    if(capacity < 0){
                        left.offer(List.of(leftCur.get(0), Math.abs(capacity)));
                    }
                }                
            }
        }

        System.out.println(totalDist);
    }
}

