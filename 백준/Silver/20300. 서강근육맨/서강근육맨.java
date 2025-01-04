import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<BigInteger> list = Arrays.stream(br.readLine().split(" "))
        .map(i -> new BigInteger(i)).sorted().collect(Collectors.toList());

        BigInteger max = new BigInteger("0");
        if(list.size() % 2 == 1) {
            max = list.get(list.size() - 1);
            list = list.subList(0, list.size() - 1);
        }

        int lo = 0;
        int hi = list.size() - 1;

        while (lo < hi) {
            BigInteger sum = list.get(lo).add(list.get(hi));
            if(max.compareTo(sum) < 0){
                max = sum;
            }
            lo++;
            hi--;
        }

        System.out.println(max);

        br.close();

    }
}
