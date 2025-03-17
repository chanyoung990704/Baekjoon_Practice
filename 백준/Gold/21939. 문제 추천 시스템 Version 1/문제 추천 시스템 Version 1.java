import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>(); // 난이도, 문제들
        Map<Integer, Integer> map2 = new HashMap<>(); // 문제, 난이도
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int p = input[0];
            int d = input[1];

            map.computeIfAbsent(d, k -> new TreeSet<>()).add(p);
            map2.put(p, d);
        }

        int M = Integer.valueOf(br.readLine());
        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("add")) {
                int p = Integer.valueOf(input[1]);
                int d = Integer.valueOf(input[2]);
                map.computeIfAbsent(d, k -> new TreeSet<>()).add(p);
                map2.put(p, d);
            } else if (input[0].equals("recommend")) {
                int op = Integer.valueOf(input[1]);
                if (op == 1) {
                    System.out.println(map.lastEntry().getValue().last());
                }else{
                    System.out.println(map.firstEntry().getValue().first());
                }
            } else if (input[0].equals("solved")) {
                // 문제 번호 P
                int p = Integer.valueOf(input[1]);

                // 난이도 찾기 & 제거
                Integer d = map2.get(p);
                map2.remove(p);

                // 트리맵에서 제거
                map.get(d).remove(p);
                if (map.get(d).isEmpty()) {
                    map.remove(d);
                }
            }
        }

    }
}
