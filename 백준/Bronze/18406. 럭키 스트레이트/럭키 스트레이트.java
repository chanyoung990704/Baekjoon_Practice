import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays.stream(br.readLine().split(""))
        .map(Integer::valueOf).collect(Collectors.toList());

        int lo = 0;
        int hi = list.size() - 1;

        int left = 0;
        int right = 0;

        while (lo < hi) {
            left += list.get(lo++);
            right += list.get(hi--);
        }

        if(left == right) System.out.println("LUCKY");
        else System.out.println("READY");


        br.close();

    }
}
