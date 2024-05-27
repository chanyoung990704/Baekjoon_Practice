#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

const int INF = 1e9;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int V, E;
    cin >> V >> E;

    vector<vector<pair<int, int>>> adj(V + 1);

    for (int i = 0; i < E; ++i) {
        int from, to, dist;
        cin >> from >> to >> dist;
        adj[from].push_back({to, dist});
    }

    int ret = INF;

    for (int start = 1; start <= V; ++start) {
        // 다익스트라 초기화
        vector<int> dist(V + 1, INF);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

        dist[start] = 0;
        pq.push({0, start});

        while (!pq.empty()) {
            int cur_dist = pq.top().first;
            int cur_idx = pq.top().second;
            pq.pop();

            if (cur_dist > dist[cur_idx])
                continue;

            for (auto& next : adj[cur_idx]) {
                int next_idx = next.first;
                int next_dist = next.second;

                // 만약 현재 노드에서 다시 시작 노드로 돌아가는 간선이 존재하면, 사이클을 발견한 것이므로 확인
                if (next_idx == start) {
                    ret = min(ret, cur_dist + next_dist);
                } else if (cur_dist + next_dist < dist[next_idx]) {
                    dist[next_idx] = cur_dist + next_dist;
                    pq.push({dist[next_idx], next_idx});
                }
            }
        }
    }

    if (ret == INF)
        cout << -1 << "\n";
    else
        cout << ret << "\n";

    return 0;
}
