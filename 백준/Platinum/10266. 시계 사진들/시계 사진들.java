import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb1 = new StringBuilder("0".repeat(360000));
        StringBuilder sb2 = new StringBuilder("0".repeat(360000));

        int n = Integer.valueOf(br.readLine());
        for(String s : br.readLine().split(" ")){
            sb1.setCharAt(Integer.valueOf(s), '1');
        }

        for(String s : br.readLine().split(" ")){
            sb2.setCharAt(Integer.valueOf(s), '1');
        }

        if (kmp(sb1.toString() + sb1.toString(), sb2.toString())) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }
    }

    private static boolean kmp(String s, String p) {
        int begin = 0;
        int matched = 0;
        int[] pi = getPi(p);

        while (begin <= s.length() - p.length()) {
            if (matched < p.length() && s.charAt(begin + matched) == p.charAt(matched)) {
                matched++;
                if(matched == p.length()){
                    return true;
                }
            } else if (matched == 0) {
                begin++;
            } else {
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
            }
        }

        return false;
    }

    private static int[] getPi(String string) {
        int[] pi = new int[string.length()];

        int begin = 1;
        int matched = 0;

        while (begin + matched < string.length()) {
            if (string.charAt(begin + matched) == string.charAt(matched)) {
                matched++;
                pi[begin + matched - 1] = matched;
            } else if (matched == 0) {
                begin++;
            }else{
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
            }
        }

        return pi;
    }
}
