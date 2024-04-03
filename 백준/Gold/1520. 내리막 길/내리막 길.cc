#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int dy[4] = { 0,0,1,-1 };
int dx[4] = { 1,-1,0,0 };

int dfs(int y, int x, vector<vector<int>>& arr, vector<vector<int>>& dp) {

	// basecase
	if (y == arr.size() - 1 && x == arr[0].size() - 1)
		return 1;

	// dp
	int& ret = dp[y][x];
	if (ret != -1)
		return ret;

	ret = 0; // 방문배열 visited 용도
	// 상하좌우 이동
	for (int i = 0; i < 4; i++) {
		int nextY = y + dy[i];	int nextX = x + dx[i];
		// 범위 안에 포함
		if (nextY >= 0 && nextY <= arr.size() - 1 && nextX >= 0 && nextX <= arr[0].size() - 1)
			// 현재보다 작은쪽으로
			if (arr[y][x] > arr[nextY][nextX])
				ret += dfs(nextY, nextX, arr, dp);

	}

	return ret;

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N; // 세로
	int M;	cin >> M; // 가로
	vector<vector<int>> arr(N, vector<int>(M, 0));
	vector<vector<int>> dp(N, vector<int>(M, -1));
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cin >> arr[i][j];

	// dfs
	cout << dfs(0, 0, arr, dp) << "\n";
}