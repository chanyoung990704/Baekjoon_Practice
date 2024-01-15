#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void dfs(vector<int>& numArr, vector<bool>& visited, int idx, int cnt, int& S, int& result) {

	if (cnt > 0) // 계산
	{
		int sum = 0;
		for (int i = 0; i < visited.size(); i++)
			if (visited[i])
				sum += numArr[i];

		if (sum == S)
			result++;
	}

	for(int i = idx ; i < numArr.size() ; i++)
		if (!visited[i]) {
			visited[i] = true;
			dfs(numArr, visited, i, cnt + 1, S, result);
			visited[i] = false;
		}


}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	int S;	cin >> S;

	vector<int> numArr(N);
	vector<bool> visited(N, false);

	for (int i = 0; i < N; i++)
		cin >> numArr[i];

	int result = 0;
	dfs(numArr, visited, 0, 0, S, result);

	cout << result << "\n";

}