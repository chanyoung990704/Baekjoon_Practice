#include <algorithm>
#include <iostream>
#include <vector>
#include <string>
#include <map>

using namespace std;

bool dfs(string input, vector<bool>& visited, vector<int>& result, int idx, int N) {

	if (result.size() == N) { // N 개의 수열 전부 저장했다면
		return true;
	}

	if (idx >= input.size())
		return false;


	if (idx < input.size()) {
		int stoiN = stoi(input.substr(idx, 1));

		if (stoiN == 0)
			return false;

		if (!visited[stoiN] && 1<= stoiN && stoiN <= N) {

			visited[stoiN] = true;
			result.push_back(stoiN);
			if (dfs(input, visited, result, idx + 1, N)) {
				return true;
			}
			visited[stoiN] = false;
			result.pop_back();
		}

	}



	if (idx + 1 < input.size()) {

		if (input.substr(idx, 1) == "0")
			return false;

		int stoiN = stoi(input.substr(idx, 2));

		if (!visited[stoiN] && 1 <= stoiN && stoiN <= N) {

			visited[stoiN] = true;
			result.push_back(stoiN);
			if (dfs(input, visited, result, idx + 2, N)) {
				return true;
			}
			visited[stoiN] = false;
			result.pop_back();
		}

	}




	return false;

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string input;	cin >> input;

	int N; // N까지의 수 수열 구하기
	if (input.size() <= 9)
		N = input.size();
	else
		N = 9 + (input.size() - 9) / 2;

	vector<bool> visited(N + 1, false);
	vector<int> result;

	if (dfs(input, visited, result, 0, N))
		for (int num : result)
			cout << num << " ";

}
