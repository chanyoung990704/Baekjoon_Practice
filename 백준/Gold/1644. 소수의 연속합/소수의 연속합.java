import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        // 소수 구하기
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(isPrime[i]){
                for(int j = i * i ; j <= N ; j += i){
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if(isPrime[i]){
                primes.add(i);
            }
        }

        int lo = 0;
        int hi = 0;
        int sum = 0;
        int cnt = 0;

        while (hi < primes.size()) {
            sum += primes.get(hi);

            while (lo < primes.size() && sum >= N) {
                if (sum == N) {
                    cnt++;
                }
                sum -= primes.get(lo);
                lo++;
            }

            hi++;
        }


        System.out.println(cnt);


    }
}
