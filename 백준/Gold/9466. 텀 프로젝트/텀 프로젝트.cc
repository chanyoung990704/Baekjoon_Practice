#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int dfs(int cur, vector<bool>& visited, vector<bool>& isFinish, vector<int>& adj) {
    visited[cur] = true;
    int next = adj[cur];
    int cnt = 0; // 사이클 포함 노드 개수

    if (!visited[next])
        cnt += dfs(next, visited, isFinish, adj);
    else if (!isFinish[next]) { // 사이클 발견
        cnt = 1;
        for (int tmp = next; tmp != cur; tmp = adj[tmp])
        {
            cnt++;
        }
    }

    isFinish[cur] = true;
    return cnt;

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;  cin >> T;
    while (T > 0)
    {
        T--;

        int n;	cin >> n;

        vector<bool> visited(n + 1, false);
        vector<bool> isFinish(n + 1, false);
        vector<int> adj(n + 1);

        for (int i = 1; i <= n; i++)
            cin >> adj[i];

        int cycleNodes = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                cycleNodes += dfs(i, visited, isFinish, adj);
        }

        cout << n - cycleNodes << "\n";

    }
}
