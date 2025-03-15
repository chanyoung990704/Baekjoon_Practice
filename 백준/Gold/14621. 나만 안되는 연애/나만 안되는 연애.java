

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
        } else if (n != parent.get(n)) {
            parent.put(n, findParent(parent.get(n)));
        }

        return parent.get(n);
    }

    static void unionParent(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);

        if (rootA < rootB) {
            parent.put(rootB, rootA);
        }else{
            parent.put(rootA, rootB);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        char[] schools = br.readLine().replaceAll(" ","").toCharArray();

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing((List<Integer> l) -> l.get(2)));
        for (int i = 0; i < M; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.offer(List.of(arr[0], arr[1], arr[2]));
        }

        int cost = 0;
        // 크루스칼
        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            int a = cur.get(0);
            int b = cur.get(1);
            int d = cur.get(2);

            // 남초 여초가 아니면
            if(schools[a - 1] == schools[b - 1]) {
                continue;
            }

            // 사이클 아닐때만
            if(findParent(a) != findParent(b)) {
                unionParent(a, b);
                cost += d;
            }

        }

        int p = findParent(N);

        // 모든 노드가 같은 부모인지 확인
        for (int i = 1; i <= N; i++) {
            if (findParent(i) != p) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(cost);
    }
}
