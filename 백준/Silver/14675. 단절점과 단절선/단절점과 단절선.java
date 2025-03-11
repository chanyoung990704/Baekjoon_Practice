

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i = 0; i < N - 1; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map.computeIfAbsent(input[0], k -> new HashSet<>()).add(input[1]);
            map.computeIfAbsent(input[1], k -> new HashSet<>()).add(input[0]);
        }

        int q = Integer.valueOf(br.readLine());

        for(int i = 0; i < q; i++) {
            int[] op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 단절점인 경우
            if(op[0] == 1){
                int idx = op[1];
                // 연결된 노드 수 찾기
                int cnt = map.get(idx).size();
                if(cnt == 1){
                    System.out.println("no");
                } else if (cnt > 1) {
                    System.out.println("yes");
                }
            }
            if (op[0] == 2) {
                System.out.println("yes");
            }

        }

    }
}
