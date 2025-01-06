import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            int sum = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::valueOf).sum();
            if (sum == 0) break;
            else System.out.println(sum);
        }

    }
}
