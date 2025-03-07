
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        // 한 자리 소수부터 시작 (2, 3, 5, 7)
        int[] firstPrimes = {2, 3, 5, 7};
        for (int prime : firstPrimes) {
            generatePrime(prime, 1, N, sb);
        }

        System.out.println(sb.toString());
    }

    // 소수 생성 함수
    private static void generatePrime(int num, int depth, int N, StringBuilder sb) {
        // N 자리수에 도달하면 결과 추가
        if (depth == N) {
            sb.append(num).append("\n");
            return;
        }

        // 다음 자릿수 추가 (0-9)
        for (int i = 0; i <= 9; i++) {
            int next = num * 10 + i;
            // 다음 숫자가 소수인 경우만 계속 진행
            if (isPrime(next)) {
                generatePrime(next, depth + 1, N, sb);
            }
        }
    }

    // 소수 판별 함수 - 최적화
    private static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        
        // 제곱근까지만 확인하면 소수 판별 가능
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
