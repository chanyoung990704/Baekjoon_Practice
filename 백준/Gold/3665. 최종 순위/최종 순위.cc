#include <algorithm>
#include <iostream>
#include <vector>	
#include <queue>	

using namespace std;

void topology(vector<vector<int>>& adj, vector<int>& indegree, vector<int>& teamRank, int n) {

	queue<int> q;
	vector<int> result;

	// indegree 0 인 것 큐에 삽입
	for (int idx : teamRank) {
		if (indegree[idx] == 0)
			q.push(idx);
	}

	while (!q.empty()) {
		int idx = q.front();
		q.pop();

		result.push_back(idx);

		// 연결되있는 간선 끊기
		for (int i = 1; i < n + 1; i++) {
			if (adj[idx][i] == 1) {
				indegree[i]--;
				if (indegree[i] == 0)
					q.push(i);
			}
		}

	}
	
	if (result.size() == n) {
		for (int res : result)
			cout << res << " ";
		cout << "\n";
	}
	else {
		cout << "IMPOSSIBLE\n";
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t;	cin >> t;
	while (t > 0) {

		int n;	cin >> n; // 팀의 수
		vector<int> teamRank(n); // 1등부터 팀 순위 기록
		for (int i = 0; i < n; i++)
			cin >> teamRank[i];

		// 간선만들기
		vector<vector<int>> adj(n + 1, vector<int>(n + 1, 0)); // 팀의 idx는 1번부터
		vector<int> indegree(n + 1, 0);

		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				adj[teamRank[i]][teamRank[j]]++;
				indegree[teamRank[j]]++;
			}

		// 순위 변경
		int m;	cin >> m;	// 몇개의 순위가 바뀌었는지
		vector<pair<int, int>> rankChange(m);
		for (int i = 0; i < m; i++) {
			cin >> rankChange[i].first;
			cin >> rankChange[i].second;
		}

		for (pair<int, int> ch : rankChange) {
			int idx1 = ch.first;	int idx2 = ch.second;
			// 원래 idx1 -> idx2 순위였을 경우
			if (adj[idx1][idx2] == 1) {
				// 간선 방향 바꾼다
				adj[idx1][idx2] = 0;
				adj[idx2][idx1] = 1;
				// indegree 수정한다
				indegree[idx2]--;
				indegree[idx1]++;
			}
			else {
				adj[idx2][idx1] = 0;
				adj[idx1][idx2] = 1;
				indegree[idx1]--;
				indegree[idx2]++;
			}

		}

		// 위상정렬
		topology(adj, indegree, teamRank, n);

		t--;
	}

}