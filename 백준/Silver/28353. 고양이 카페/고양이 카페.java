import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NK.get(0);
        int K = NK.get(1);

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).sorted().collect(Collectors.toList());

        int lo = 0;
        int hi = list.size() - 1;
        int cnt = 0;

        while (lo < hi) {
            long sum = list.get(lo) + list.get(hi);

            if(sum > K) hi--;
            else{
                cnt++;
                lo++;
                hi--;
            }
        }

        System.out.println(Math.min(cnt, N));

        br.close();

    }
}
