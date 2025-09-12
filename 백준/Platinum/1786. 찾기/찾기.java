import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();

        int[] Pi = getPi(P);

        int begin = 0;
        int matched = 0;
        List<Integer> idxs = new  ArrayList<>();

        while (begin <= T.length() - P.length()) {
            if (matched < P.length() && P.charAt(matched) == T.charAt(begin + matched)) {
                matched++;
                if (matched == P.length()) {
                    idxs.add(begin+1);
                }
            } else if (matched == 0) {
                begin++;
            }else{
                begin += matched - Pi[matched - 1];
                matched = Pi[matched - 1];
            }
        }

        System.out.println(idxs.size());
        System.out.println(idxs.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static int[] getPi(String p) {
        int[] pi = new  int[p.length()];
        int begin = 1;
        int matched = 0;

        while (begin + matched < p.length()) {
            if(p.charAt(begin + matched) == p.charAt(matched)) {
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
