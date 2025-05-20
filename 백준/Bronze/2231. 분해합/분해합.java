import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 1000000; i++) {
            String num = String.valueOf(i);
            int sum = Arrays.stream(num.split("")).mapToInt(Integer::parseInt).sum();
            sum += i;
            if (sum == N) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}
