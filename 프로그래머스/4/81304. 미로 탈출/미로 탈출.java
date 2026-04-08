import java.util.*;

class Solution {
    int INF = 1000000000;

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        // 1. 그래프 초기화 (0: 정방향, 1: 역방향)
        List<List<int[]>>[] adj = new ArrayList[2];
        for (int i = 0; i < 2; i++) {
            adj[i] = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                adj[i].add(new ArrayList<>());
            }
        }

        for (int[] road : roads) {
            int from = road[0], to = road[1], weight = road[2];
            adj[0].get(from).add(new int[]{to, weight});
            adj[1].get(to).add(new int[]{from, weight});
        }

        // 2. 다익스트라 준비
        int tlen = traps.length;
        int[][] dist = new int[n + 1][1 << tlen];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        // [현재까지 거리, 현재 노드, 현재 함정 비트마스크]
        pq.offer(new int[]{0, start, 0});
        dist[start][0] = 0;

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int currDist = p[0], currNode = p[1], bit = p[2];

            if (currNode == end) return currDist;
            if (dist[currNode][bit] < currDist) continue;

            // 현재 노드의 함정 활성화 여부 확인
            boolean currStatus = false;
            for (int i = 0; i < tlen; i++) {
                if (traps[i] == currNode && ((bit >> i) & 1) > 0) {
                    currStatus = true;
                    break;
                }
            }

            // 간선 탐색 (type 0: 원래 정방향이었던 길, type 1: 원래 역방향이었던 길)
            for (int type = 0; type <= 1; type++) {
                for (int[] next : adj[type].get(currNode)) {
                    int nextNode = next[0];
                    int edgeWeight = next[1];

                    // 다음 노드의 함정 활성화 여부 확인
                    boolean nextStatus = false;
                    for (int i = 0; i < tlen; i++) {
                        if (traps[i] == nextNode && ((bit >> i) & 1) > 0) {
                            nextStatus = true;
                            break;
                        }
                    }

                    // 논리 체크: 상태가 같으면 정방향(0), 다르면 역방향(1)이어야 이동 가능
                    boolean isFlipped = (currStatus != nextStatus);
                    int currentType = isFlipped ? 1 : 0;

                    if (type != currentType) continue;

                    // 다음 상태 비트 계산 (다음 노드가 함정이면 토글)
                    int nextBit = bit;
                    for (int i = 0; i < tlen; i++) {
                        if (traps[i] == nextNode) {
                            nextBit ^= (1 << i);
                            break;
                        }
                    }

                    if (dist[nextNode][nextBit] > currDist + edgeWeight) {
                        dist[nextNode][nextBit] = currDist + edgeWeight;
                        pq.offer(new int[]{dist[nextNode][nextBit], nextNode, nextBit});
                    }
                }
            }
        }

        return -1;
    }
}