

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long k = Long.parseLong(br.readLine());

        long lo = 1;
        long hi = (long) N * N;
        long ret = -1; // 결과값을 저장할 변수

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            // mid보다 작거나 같은 값의 개수를 계산
            long countLessOrEqual = 0;
            for (int i = 1; i <= N; i++) {
                countLessOrEqual += Math.min(N, mid / i);
            }

            if (countLessOrEqual >= k) {
                // mid가 조건을 만족하면 ret에 저장
                ret = mid;
                hi = mid - 1; // 더 작은 값을 탐색
            } else {
                lo = mid + 1; // 더 큰 값을 탐색
            }
        }

        System.out.println(ret); // 최종적으로 k번째 값 출력
    }
}
