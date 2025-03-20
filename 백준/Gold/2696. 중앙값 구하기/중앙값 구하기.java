
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.time.*;
import java.util.regex.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            // 수열의 크기 M
            int M = Integer.parseInt(br.readLine());

            // 수열
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < (M + 9) / 10; i++) {
                nums.addAll(Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList()));
            }

            // left right 각 우선순위 큐
            PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();

            List<Integer> result = new ArrayList<>();

            // 숫자 순회
            // 중간값은 left 가장 큰 수
            for (int i = 0; i < M; i++) {
                int n = nums.get(i);

                // 처음 왼쪽 삽입
                if(i == 0){
                    left.offer(n);
                }
                else if(left.peek() < n){
                    right.offer(n);
                }else{
                    left.offer(n);
                }

                // 차이가 1이상이면 조정
                if (left.size() - right.size() > 1) {
                    right.offer(left.poll());
                }

                if(right.size() - left.size() > 1){
                    left.offer(right.poll());
                }

                // 출력
                if (i % 2 == 0) {
                    // 0 base인덱스이기에

                    // 사이즈 큰게 중앙값
                    if (left.size() > right.size()) {
                        result.add(left.peek());
                    }else{
                        result.add(right.peek());
                    }
                }
            }

            // 개수와 값 한 줄에 10개씩
            System.out.print(result.size());
            for (int i = 0; i < result.size(); i++) {
                if (i % 10 == 0) {
                    System.out.println();
                }
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
    }
}
