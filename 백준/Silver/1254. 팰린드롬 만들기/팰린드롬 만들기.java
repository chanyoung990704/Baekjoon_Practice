import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuffer sb = new StringBuffer(str);
        String rev = sb.reverse().toString();

        System.out.println(str.length() + (rev.length() - getMinPellindrom(str, rev)));
    }

    private static int getMinPellindrom(String str, String rev) {
        int[] pi = getPi(rev);
        int n = str.length();
        int m = rev.length();

        int begin = 0;
        int matched = 0;

        while (begin + matched < n) {
            if (matched < m && str.charAt(begin + matched) == rev.charAt(matched)) {
                matched++;
                if (begin + matched == n) {
                    return matched;
                }
            } else if (matched == 0) {
                begin++;
            } else {
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
            }
        }

        return 0;
    }

    private static int[] getPi(String rev) {
        int begin = 1;
        int matched = 0;

        int[] pi = new int[rev.length()];
        while (begin + matched< rev.length()) {
            if (rev.charAt(matched) == rev.charAt(begin + matched)) {
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
