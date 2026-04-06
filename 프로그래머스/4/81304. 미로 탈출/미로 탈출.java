import java.util.*;

class Solution {
    int INF = 1000000000;
    
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] r : roads) {
            adj.get(r[0]).add(new int[]{r[1], r[2], 0}); // 정방향
            adj.get(r[1]).add(new int[]{r[0], r[2], 1}); // 역방향
        }

        int[][] dist = new int[n + 1][1 << traps.length];
        for (int i = 0; i <= n; i++) Arrays.fill(dist[i], INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[start][0] = 0;
        pq.offer(new int[]{0, start, 0});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int cost = p[0], node = p[1], state = p[2];

            if (node == end) return cost;
            if (dist[node][state] < cost) continue;

            // 현재 노드가 몇 번째 함정인지 실시간 확인
            int curTrapIdx = -1;
            for (int i = 0; i < traps.length; i++) {
                if (traps[i] == node) { curTrapIdx = i; break; }
            }
            boolean curTrapOn = (curTrapIdx != -1) && ((state & (1 << curTrapIdx)) != 0);

            for (int[] edge : adj.get(node)) {
                int next = edge[0], weight = edge[1], type = edge[2];

                // 다음 노드가 몇 번째 함정인지 실시간 확인
                int nextTrapIdx = -1;
                for (int i = 0; i < traps.length; i++) {
                    if (traps[i] == next) { nextTrapIdx = i; break; }
                }
                boolean nextTrapOn = (nextTrapIdx != -1) && ((state & (1 << nextTrapIdx)) != 0);

                // 방향 판별 로직 (XOR 연산과 동일)
                if (type == (curTrapOn != nextTrapOn ? 1 : 0)) {
                    int nextState = state;
                    if (nextTrapIdx != -1) nextState ^= (1 << nextTrapIdx);

                    if (dist[next][nextState] > cost + weight) {
                        dist[next][nextState] = cost + weight;
                        pq.offer(new int[]{dist[next][nextState], next, nextState});
                    }
                }
            }
        }
        return -1;
    }
}