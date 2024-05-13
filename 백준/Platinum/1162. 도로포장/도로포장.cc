#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
#include <algorithm>
#define INF 1e15

using namespace std;
typedef long long ll;
typedef tuple<ll, int, int> edge; // 비용, 현재 노드, 포장 횟수

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, k;
    cin >> n >> m >> k;

    vector<vector<pair<int, int>>> graph(n + 1);
    for (int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].push_back({v, w});
        graph[v].push_back({u, w});
    }

    // 다차원 벡터로 최소 비용을 저장, 초기값은 무한대
    vector<vector<ll>> dist(n + 1, vector<ll>(k + 1, INF));
    dist[1][0] = 0; // 시작점 초기화

    priority_queue<edge, vector<edge>, greater<edge>> pq;
    pq.push({0, 1, 0}); // 초기 비용, 시작 노드, 포장 횟수

    while (!pq.empty()) {
        auto [cost, u, used] = pq.top();
        pq.pop();

        if (cost > dist[u][used]) continue;

        for (auto &[v, w] : graph[u]) {
            // 포장하지 않는 경우
            if (dist[v][used] > cost + w) {
                dist[v][used] = cost + w;
                pq.push({dist[v][used], v, used});
            }
            // 포장하는 경우
            if (used < k && dist[v][used + 1] > cost) {
                dist[v][used + 1] = cost;
                pq.push({dist[v][used + 1], v, used + 1});
            }
        }
    }

    // 모든 포장 횟수에 대해 최소 비용을 찾음
    ll answer = *min_element(dist[n].begin(), dist[n].end());
    cout << answer << endl;

    return 0;
}