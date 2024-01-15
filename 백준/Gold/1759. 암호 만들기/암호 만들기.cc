#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void dfs(vector<char>& words, vector<bool>& visited, int idx, int L, int cnt) {

	if (cnt == L) { // 암호가 만들어졌을 경우
		string result = "";
		int j = 0; // 자음
		int m = 0; // 모음

		for (int i = 0; i < words.size(); i++)
			if (visited[i]) { // 암호를 만들 조합 원소라면
				result += words[i];
				if (words[i] == 'a' || words[i] == 'e' || words[i] == 'i' || words[i] == 'o' || words[i] == 'u')//모음이라면
					m++;
				else // 자음이라면
					j++;
			}

		if (m >= 1 && j >= 2) // 조건에 충족하면 출력
			cout << result << "\n";
	}

	for(int i = idx ; i < words.size() ; i++)
		if (!visited[i]) {
			visited[i] = true;
			dfs(words, visited, i, L, cnt + 1);
			visited[i] = false;
		}

}


int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int L;	cin >> L;
	int C;	cin >> C;

	vector<char> words(C);
	vector<bool> visited(C, false);

	for (int i = 0; i < C; i++)
		cin >> words[i];

	sort(words.begin(), words.end());

	dfs(words, visited, 0, L, 0);

}