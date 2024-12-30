import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.valueOf(br.readLine());

        long total = 0;
        long cur = 1;
        int cnt = 0;
        while (total + cur <= s) {
            total += cur;
            cur++;
            cnt++;
        }

        System.out.println(cnt);

        br.close();
    }

}