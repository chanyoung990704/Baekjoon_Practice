#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<int> failureTable(const string& pattern) {
	int size = pattern.size();
	vector<int> table(size);
	table[0] = 0;
	int j = 0;

	for (int i = 1; i < size; i++) {

		while (j > 0 && pattern[i] != pattern[j])
		{
			j = table[j - 1];
		}

		if (pattern[i] == pattern[j])
			++j;

		table[i] = j;
	}

	return table;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	string T;	getline(cin, T);
	string P;	getline(cin, P);
	int cnt = 0;
	vector<int> idx;

	vector<int> table = failureTable(P);	// 패턴의 실패함수 테이블
	int i = 0;
	int j = 0;

	for (int i = 0; i < T.size(); i++) {

		while (j > 0 && P[j] != T[i])
		{
			j = table[j - 1];
		}

		if (T[i] == P[j])
			++j;

		if (j == P.size()) {
			idx.push_back(i - j + 2);
			cnt++;
			j = table[j - 1];
		}

	}

	cout << cnt << "\n";
	for (int i : idx)
		cout << i << " ";
}