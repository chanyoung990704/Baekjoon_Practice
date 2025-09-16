import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        List<Integer> suffixArray = getSuffixArray(str);
        for(int i = 0; i < suffixArray.size(); i++) {
            System.out.println(suffixArray.get(i));
        }

    }

    static List<Integer> getSuffixArray(String s) {
        int n = s.length();

        List<Integer> group = new ArrayList<>(Collections.nCopies(n + 1, 0));
        group.set(n, -1);
        for (int i = 0; i < n; i++) {
            group.set(i, (int) s.charAt(i));
        }

        List<Integer> perm = new ArrayList<>();
        for(int i = 0; i < n; i++){
            perm.add(i);
        }

        int t = 1;

        while (t <= n) {
            final int ft = t;
            List<Integer> g = List.copyOf(group);

            perm.sort(Comparator.comparing((Integer k) -> g.get(k))
                    .thenComparing(k -> g.get(k + ft)));

            t *= 2;
            if (t >= n) {
                break;
            }

            List<Integer> newGroup =  new ArrayList<>(Collections.nCopies(n + 1, 0));
            newGroup.set(n, -1);
            newGroup.set(perm.get(0), 0);

            for (int i = 1; i < n; i++) {
                if (comp(perm.get(i - 1), perm.get(i), t / 2, group)) {
                    newGroup.set(perm.get(i), newGroup.get(perm.get(i - 1)) + 1);
                } else {
                    newGroup.set(perm.get(i), newGroup.get(perm.get(i - 1)));
                }
            }

            group = newGroup;
        }

        return perm;
    }

    private static boolean comp(Integer a, Integer b, int t, List<Integer> group) {
        if(group.get(a) != group.get(b)) {
            return group.get(a) < group.get(b);
        }
        return group.get(a + t) < group.get(b + t);
    }
}
