#include <iostream>
#include <string>

using namespace std;

bool isGood(string s) {
	int len = s.length();
	for (int i = 1; i <= len / 2; i++) {
		if (s.substr(len - i, i) == s.substr(len - i * 2, i))
			return false;
	}
	return true;
}

void dfs(int N, string s) {
	if (!isGood(s)) return;
	if (s.length() == N) {
		cout << s;
		exit(0);
	}
	for (int i = 1; i <= 3; i++)
		dfs(N, s + to_string(i));
}

int main() {
	int N;	cin >> N;
	dfs(N, "1");
	return 0;
}
