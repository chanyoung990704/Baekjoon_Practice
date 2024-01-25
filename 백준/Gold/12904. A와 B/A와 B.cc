#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string S;	 cin >> S; // 원본
	string T;	 cin >> T; // 목표값

	while (S.size() < T.size()) {
		char lastChar = T.back();
		T.pop_back();

		if (lastChar == 'B') {
			reverse(T.begin(), T.end());
		}
	}

	if (S == T)
		cout << 1 << "\n";
	else
		cout << 0 << "\n";

    return 0;
}
