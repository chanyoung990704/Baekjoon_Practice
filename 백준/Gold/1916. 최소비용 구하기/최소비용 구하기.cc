#include <iostream>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

const int INF = numeric_limits<int>::max();

int get_min_node(const vector<int>& min_cost, const vector<bool>& visited) {
    int min_index = -1;
    int min_value = INF;

    for (int i = 1; i < visited.size(); i++) {
        if (!visited[i] && min_cost[i] < min_value) {
            min_value = min_cost[i];
            min_index = i;
        }
    }

    return min_index;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<vector<pair<int, int>>> adj(N + 1);
    for (int i = 0; i < M; i++) {
        int from, to, cost;
        cin >> from >> to >> cost;
        adj[from].push_back(make_pair(to, cost));
    }

    int start, finish;
    cin >> start >> finish;

    vector<bool> visited(N + 1, false);
    vector<int> min_cost(N + 1, INF);
    min_cost[start] = 0;

    while (true) {
        int current = get_min_node(min_cost, visited);
        if (current == -1) break; // 모든 노드가 방문되었거나, 방문할 수 없는 노드만 남았을 때 종료
        visited[current] = true;

        for (const auto& next : adj[current]) {
            int next_node = next.first;
            int weight = next.second;
            if (min_cost[next_node] > min_cost[current] + weight) {
                min_cost[next_node] = min_cost[current] + weight;
            }
        }
    }

    cout << min_cost[finish] << "\n";

    return 0;
}