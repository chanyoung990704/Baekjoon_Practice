#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int bfs(int start, int target, vector<vector<int>>& adj, vector<bool>& visited) {
    queue<pair<int, int>> q;
    q.push({ start, 0 });
    visited[start] = true;

    while (!q.empty()) {
        int curNode = q.front().first;
        int curCnt = q.front().second;
        q.pop();

        if (curNode == target) {
            return curCnt;
        }

        for (int next : adj[curNode]) {
            if (!visited[next]) {
                visited[next] = true;
                q.push({ next, curCnt + 1 });
            }
        }
    }

    return -1; // 목표 노드에 도달할 수 없는 경우
}

int main() {
    int N;	cin >> N; // 유저 수
    int M;	cin >> M; // 친구 관계 수

    vector<vector<int>> adj(N + 1, vector<int>(N + 1, 0));

    for (int i = 0; i < M; ++i) {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    int minBacon = 987654321;
    int minPerson = 0;

    for (int i = 1; i <= N; ++i) {
        int baconNumber = 0;
        for (int j = 1; j <= N; ++j) {
            if (i != j) {
                vector<bool> visited(N + 1, false);
                baconNumber += bfs(i, j, adj, visited);
            }
        }

        if (minBacon > baconNumber) {
            minBacon = baconNumber;
            minPerson = i;
        }
    }

    cout << minPerson << endl;

    return 0;
}
