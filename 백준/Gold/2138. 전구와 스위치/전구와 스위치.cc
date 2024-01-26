#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

char swapChar(char c) {
	if (c == '0')
		return '1';
	else
		return '0';
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N;		 cin >> N;
	string S;	 cin >> S; // 전구 현재 상태
	string T;	 cin >> T; // 전구 목표 상태

	int FirstOnCnt = 0; // 첫번째 전구 켰을 경우
	int cnt = 0; // 원래 주어진 대로

	string backup = S;

	// 주어진 경우에서 탐색
	for (int i = 0; i < N; i++) {
		if (i == N - 1) {
			if (S != T)
			{
				cnt = 987654321;
				break;
			}
		}

		if (S[i] != T[i]) {
			cnt++;
			S[i] = T[i];
			S[i + 1] = swapChar(S[i + 1]);
			if(i + 2 < N)
				S[i + 2] = swapChar(S[i + 2]);
		}
	}

	// 첫번째 스위치 바꾼 후 탐색
	backup[0] = swapChar(backup[0]);
	backup[1] = swapChar(backup[1]);
	FirstOnCnt++;
	for (int i = 0; i < N; i++) {
		if (i == N - 1) {
			if (backup != T)
			{
				FirstOnCnt = 987654321;
				break;
			}
		}

		if (backup[i] != T[i]) {
			FirstOnCnt++;
			backup[i] = T[i];
			backup[i + 1] = swapChar(backup[i + 1]);
			if (i + 2 < N)
				backup[i + 2] = swapChar(backup[i + 2]);
		}
	}
	
	int result = min(cnt, FirstOnCnt);

	if (result == 987654321)
		cout << "-1\n";
	else
		cout << result << "\n";
}
