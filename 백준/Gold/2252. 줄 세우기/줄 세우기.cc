#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

void DFS(int cur, vector<vector<int>>& adj, vector<bool>& visited, vector<int>& result) {
    visited[cur] = true;
    for (int next : adj[cur]) {
        if (!visited[next]) {
            DFS(next, adj, visited, result);
        }
    }
    result.push_back(cur);
}

int main() {
    int n, m, f, t;
    cin >> n >> m;

    vector<vector<int>> adj(n);
    vector<int> indegree(n, 0);

    for (int i = 0; i < m; i++) {
        cin >> f >> t;
        adj[f - 1].push_back(t - 1);
        indegree[t - 1]++;
    }

    vector<int> result;
    vector<bool> visited(n, false);

    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0 && !visited[i]) {
            DFS(i, adj, visited, result);
        }
    }

    reverse(result.begin(), result.end());

    for (int student : result) {
        cout << student + 1 << " ";
    }
    cout << endl;

    return 0;
}
