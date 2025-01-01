import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 공의 개수
        int K = Integer.parseInt(st.nextToken()); // 바구니 개수

        // 최소 필요한 공의 개수 계산
        int minRequired = (K * (K + 1)) / 2;

        // 조건을 만족하지 못하는 경우
        if (N < minRequired) {
            System.out.println(-1);
            return;
        }

        // 남은 공 계산
        int remaining = N - minRequired;

        // 결과 계산
        if (remaining % K == 0) {
            System.out.println(K - 1); // 균등하게 분배 가능
        } else {
            System.out.println(K); // 균등하게 분배 불가능
        }
    }
}
