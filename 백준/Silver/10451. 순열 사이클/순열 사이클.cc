#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>
#include <queue>

using namespace std;

int dfs(vector<vector<int>>& adj, vector<bool>& visited, int cur) {

	visited[cur] = true;

	for (int next : adj[cur]) {
		if (!visited[next]) {
			visited[next] = true;
			dfs(adj, visited, next);
		}
	}

	return 1;
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1 ~ 8 입력 -> 간선 -> 1 ~ 8 dfs
	int T;	cin >> T;
	while (T > 0) {
		T--;

		int N;	cin >> N;

		vector<vector<int>> adj(N + 1);
		vector<bool> visited(N + 1, false);

		for (int i = 1; i <= N; i++) {
			int num;	cin >> num;
			adj[i].push_back(num);
		}

		int cycle = 0;

		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				cycle += dfs(adj, visited, i);
		}

		cout << cycle << "\n";
	}

}
