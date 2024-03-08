#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> topologicalSort(vector<vector<int>>& adj, vector<int>& indegree, int N) {

	priority_queue<int, vector<int>, greater<int>> pq;
	for (int i = 0; i < N; i++) {
		if (indegree[i] == 0)
			pq.push(i);
	}

	vector<int> result;
	while (!pq.empty())
	{
		int cur = pq.top();
		result.push_back(cur);
		pq.pop();

		for (int next : adj[cur])
		{
			indegree[next]--;
			if (indegree[next] == 0)
				pq.push(next);
		}
	}

	// 사이클 확인 로직
	if (result.size() != N)
		result = vector<int>();

	return result;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	int M;	cin >> M;

	vector<vector<int>> adj(N); // 시작 정점 0번부터
	vector<int> indegree(N, 0);
	for (int i = 0; i < M; i++) {
		int u;	cin >> u;
		int v;	cin >> v;

		adj[u - 1].push_back(v - 1);
		indegree[v - 1]++;
	}

	// 우선순위 큐 사용 위상정렬
	vector<int> result = topologicalSort(adj, indegree, N);

	for (int r : result) // 출력은 시작 정점 1번부터
		cout << r + 1 << " ";
}