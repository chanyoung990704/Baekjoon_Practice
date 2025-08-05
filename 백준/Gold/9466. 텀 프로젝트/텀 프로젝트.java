import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.valueOf(br.readLine());
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 그래프 생성
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                map.put(i+1, nums[i]);
            }

            BitSet visited = new BitSet();
            BitSet finished = new BitSet();
            int[] cycled = new int[1];

            for(int i = 1 ; i <= n; i++) {
                if (!visited.get(i)) {
                    dfs(visited, finished, i, map, cycled);
                }
            }

            System.out.println(n - cycled[0]);
        }
    }

    private static void dfs(BitSet visited, BitSet finished, int i, Map<Integer, Integer> map, int[] cycled) {
        visited.set(i);
        int next = map.get(i);

        if(!visited.get(next)) {
            dfs(visited, finished, next, map, cycled);
        }else if(!finished.get(next)) {
            int child = i;
            while (map.get(child) != i) {
                cycled[0]++;
                child = map.get(child);
            }
            cycled[0]++;
        }

        finished.set(i);
    }
}
