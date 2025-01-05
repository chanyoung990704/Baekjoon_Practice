import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        List<Integer> NKAB = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());

        int N = NKAB.get(0); // 화분 개수
        int K = NKAB.get(1); // 초기 수분
        int A = NKAB.get(2); // 물을 줄 연속된 화분의 개수
        int B = NKAB.get(3); // 물을 줄 때의 수분 증가량

        // N개의 화분을 초기 수분 K로 설정
        List<Integer> list = new ArrayList<>(Collections.nCopies(N, K));
        int day = 0;

        // 매일 물을 주는 작업 반복
        while (true) {
            day++;

            // 정렬하여 가장 적은 A개의 화분에 물을 줌
            list.sort(Comparator.naturalOrder()); // 수분이 적은 순으로 정렬
            for (int i = 0; i < A; i++) {
                list.set(i, list.get(i) + B); // 물을 추가
            }

            // 모든 화분의 수분 1씩 감소
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) - 1);
            }

            // 화분 중 하나라도 수분이 0이면 종료
            if (list.contains(0)) {
                break;
            }
        }

        // 결과 출력
        System.out.println(day);
    }
}
