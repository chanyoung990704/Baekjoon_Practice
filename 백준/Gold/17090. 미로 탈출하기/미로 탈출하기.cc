#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int N;
int M;

int dfs(vector<vector<char>>& map, vector<vector<int>>& dp, int y, int x) {

	if (y < 0 || y >= N || x < 0 || x >= M)
		return 1;

	int& ret = dp[y][x];
	if (ret != -1)
	{
		return ret;
	}

	int nextY = -1;
	int nextX = -1;
	if (map[y][x] == 'U') {
		nextY = y - 1;
		nextX = x;
	}
	else if (map[y][x] == 'R') {
		nextY = y;
		nextX = x + 1;
	}
	else if (map[y][x] == 'D') {
		nextY = y + 1;
		nextX = x;
	}
	else {
		nextY = y;
		nextX = x - 1;
	}

	ret = 0;
	ret = dfs(map, dp, nextY, nextX);
	return ret;

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	cin >> M;
	vector<vector<char>> map(N, vector<char>(M, 0));

	for (int i = 0; i < N; i++) {
		string s;	cin >> s;
		for (int j = 0; j < M; j++)
			map[i][j] = s[j];
	}

	vector<vector<int>> dp(N, vector<int>(M, -1));

	int cnt = 0;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cnt += dfs(map, dp, i, j);


	cout << cnt << "\n";

}