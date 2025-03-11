
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NKQM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NKQM[0];
        int K = NKQM[1];
        int Q = NKQM[2];
        int M = NKQM[3];

        List<Integer> k = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> q = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<List<Integer>> m = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            m.add(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }

        // 졸고있는 학생 set으로 저장
        Set<Integer> sleepingStudents = new HashSet<>(k);

        // 출석 체크 배열 (0: 미체크, 1: 체크됨)
        int[] attendance = new int[N + 3]; // 학생 번호가 3부터 N+2까지이므로

        // 출석 체크 전달 로직
        for (int starter : q) {
            // 출석 체크를 시작하는 학생이 자고 있다면 전달 불가
            if (sleepingStudents.contains(starter)) {
                continue;
            }

            // 출석 체크 전달 (배수로 전달)
            for (int i = starter; i <= N + 2; i += starter) {
                // 전달 받는 학생이 자고 있지 않은 경우만 체크
                if (!sleepingStudents.contains(i)) {
                    attendance[i] = 1;
                }
            }
        }

        // 누적합 계산 (인덱스 1부터 시작하도록)
        int[] prefixSum = new int[N + 3];
        for (int i = 3; i <= N + 2; i++) {
            prefixSum[i] = prefixSum[i - 1] + (1 - attendance[i]); // 체크되지 않은 학생 수를 누적
        }

        // 구간 쿼리 처리
        for (List<Integer> range : m) {
            int start = range.get(0);
            int end = range.get(1);
            // 체크되지 않은 학생 수 = (구간 끝의 누적합) - (구간 시작 바로 이전의 누적합)
            int uncheckedStudents = prefixSum[end] - prefixSum[start - 1];
            System.out.println(uncheckedStudents);
        }
    }
}
