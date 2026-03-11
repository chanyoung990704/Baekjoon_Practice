import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;

    static int max = 4000000;
    static boolean isPrime[] = new boolean[max + 1];
    static List<Integer> nums = new ArrayList<>();

    static int ret = 0;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        makePrimeArr();
        // 소수인 것들 다 담기.
        for (int i = 0; i <= max; i++) {
            if (isPrime[i]) {
                nums.add(i);
            }
        }

        // 투포인터 구간 길이
        int lo = 0, hi = 0;
        int total = 0;
        while (hi < nums.size()) {
            total += nums.get(hi);

            while (lo <= hi && total >= N) {
                if (total == N) {
                    ret++;
                }
                total -= nums.get(lo);
                lo++;
            }

            hi++;
        }

        System.out.println(ret);
    }

    private static void makePrimeArr() {
        Arrays.fill(isPrime, true);
        // 0은 1은 소수 아님
        isPrime[0] = isPrime[1] = false;

        for (int i = 0; i <= Math.sqrt(max); i++) {
            // 현재 소수면 갱신
            if(isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}