import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        List<Integer> nums = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> sums = new ArrayList<>();
        sums.add(0);
        for(int n : nums) sums.add(n + sums.get(sums.size() - 1));

        for(int i = 0 ; i < M ; i++) {
            List<Integer> ij = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            
            int curI = ij.get(0);
            int curJ = ij.get(1);

            System.out.println(sums.get(curJ) - sums.get(curI - 1));
        }


        br.close();

    }
}
