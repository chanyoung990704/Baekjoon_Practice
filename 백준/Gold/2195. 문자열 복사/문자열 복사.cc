#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string S;	cin >> S;
	string P;	cin >> P;

	int pIdx = 0;
	int cnt = 0;

	while (pIdx < P.size()) {

		size_t sIdx = S.find(P[pIdx]);
		int nextPidx = 0;
		while (sIdx != string::npos) {

			int i = pIdx;
			for (; i < P.size(); i++) {
				if (P[i] != S[sIdx])
					break;
				sIdx++;
			}

			nextPidx = max(nextPidx, i);
			sIdx = S.find(P[pIdx], sIdx + 1);
		}

		pIdx = nextPidx;
		cnt++;
	}

	cout << cnt << "\n";
}