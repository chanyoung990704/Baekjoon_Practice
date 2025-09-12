import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.valueOf(br.readLine());
        String str = br.readLine();

        int[] pi = getPi(str);
        System.out.println(L - pi[str.length() - 1]);

    }

    private static int[] getPi(String str) {
        int[] pi = new int[str.length()];
        int begin, matched;
        begin = 1;
        matched = 0;

        while (begin + matched < str.length()) {
            if (str.charAt(matched) == str.charAt(begin + matched)) {
                matched++;
                pi[begin + matched - 1] = matched;
            } else if (matched == 0) {
                begin++;
            } else {
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
            }
        }

        return pi;
    }
}
