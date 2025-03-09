
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    static Map<Integer, Integer> parent = new HashMap<>();

    static int findParent(int n) {
        if(!parent.containsKey(n)) {
            parent.put(n, n);
        } else if (parent.get(n) != n) {
            parent.put(n, findParent(parent.get(n)));
        }
        return parent.get(n);
    }

    static void unionParent(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);

        if (rootA > rootB) {
            parent.put(rootA, rootB);
        } else {
            parent.put(rootB, rootA);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M == 0) {
            System.out.println(N);
            return;
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            for (int j = a; j < b; j++) {
                if (findParent(j) != findParent(j + 1)) {
                    unionParent(j, j + 1);
                }
            }
        }


        Set<Integer> set = new HashSet<>();
        for(int i = 1 ; i <= N ; i++) {
            set.add(findParent(i));
        }

        System.out.println(set.size());
    }
}
