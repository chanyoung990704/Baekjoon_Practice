import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        TreeMap<Integer, TreeSet<Integer>> recommends = new TreeMap<>();
        Map<Integer, Integer> nums = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int P = input[0];
            int L =  input[1];

            recommends.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
            nums.put(P, L);
        }

        int M =  Integer.valueOf(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("add")) {
                int P = Integer.parseInt(input[1]);
                int L =  Integer.parseInt(input[2]);

                recommends.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
                nums.put(P, L);
            } else if (input[0].equals("recommend")) {
                int x = Integer.parseInt(input[1]);
                if (x == 1) {
                    System.out.println(recommends.get(recommends.lastKey()).last());
                } else if (x == -1) {
                    System.out.println(recommends.get(recommends.firstKey()).first());
                }
            } else if (input[0].equals("solved")) {
                int P = Integer.parseInt(input[1]);
                int level = nums.get(P);
                recommends.get(level).remove(P);
                if (recommends.get(level).isEmpty()) {
                    recommends.remove(level);
                }
            }
        }
    }
}
