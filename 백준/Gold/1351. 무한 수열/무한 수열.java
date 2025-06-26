import java.io.*;
import java.util.*;

public class Main {
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);  // Long.parseLong 사용
        int P = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);

        System.out.println(solve(N, P, Q));
    }

    private static Long solve(Long n, int p, int q) {
        if(n == 0){
            return 1L;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }

        Long val = solve(n / p, p, q) + solve(n / q, p, q);
        map.put(n, val);

        return val;
    }
}
