#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int solve(int n, vector<vector<int>>& map, vector<vector<int>>& dp, int prev, int N) {

	if (n == N)
		return 0;

	if (dp[n][prev] != -1)
		return dp[n][prev];

	int& result = dp[n][prev];

	// 왼쪽 위를 뗀 경우
	if(prev != 1)
		result = max(result, map[0][n] + solve(n + 1, map, dp, 1, N));
	// 왼쪽 아래를 뗀 경우
	if (prev != 2)
		result = max(result, map[1][n] + solve(n + 1, map, dp, 2, N));
	//아무것도 안 뗀 경우
	result = max(result, solve(n + 1, map, dp, 0, N));

	return result;

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;	cin >> T;
	while (T > 0) {
		T--;

		int N;	cin >> N;
		vector<vector<int>> map(2, vector<int>(N, 0));
		vector<vector<int>> dp(N, vector<int>(3, -1));

		for (int i = 0; i < 2; i++)
			for (int j = 0; j < N; j++)
				cin >> map[i][j];

		cout << solve(0, map, dp, 0, N) << "\n";

	}

}