import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        while (true) {

            int[] LPV = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int L = LPV[0];
            int P = LPV[1];
            int V = LPV[2];

            if(L == 0 && P == 0 && V == 0) {
                break;
            }

            int ret = 0;
            int d = V / P;
            ret += d * L;

            ret += Math.min(L, V % P);

            System.out.println("Case " + idx + ": " + ret);

            idx++;
        }

    }
}
