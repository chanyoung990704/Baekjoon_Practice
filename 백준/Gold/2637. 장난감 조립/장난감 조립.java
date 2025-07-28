import java.io.*;
import java.util.*;

public class Main {

    static class Block{
        int y;
        int k;

        public Block(int y, int k) {
            this.y = y;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());

        int[][] dp = new int[N + 1][N + 1];

        List<List<Integer>> outDegree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            outDegree.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];

        Map<Integer, List<Block>>  map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 블록의 구성 요소 저장
            map.computeIfAbsent(arr[0], k -> new ArrayList<>()).add(new Block(arr[1], arr[2]));
            // degree
            outDegree.get(arr[1]).add(arr[0]);
            inDegree[arr[0]]++;
        }

        // Indegree 0 인거 작업
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                dp[i][i] = 1;
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 현재 노드가 중간 부품인 경우
            if (map.containsKey(cur)) {
                List<Block> blocks = map.get(cur); // cur에 해당하는 블록들만 가져오기
                for (Block block : blocks) {
                    for (int i = 1; i <= N; i++) {
                        if (dp[block.y][i] > 0) {
                            dp[cur][i] += dp[block.y][i] * block.k;
                        }
                    }
                }
            }


            for(int next : outDegree.get(cur)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N; i++){
            if (dp[N][i] > 0) {
                sb.append(i).append(" ").append(dp[N][i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
