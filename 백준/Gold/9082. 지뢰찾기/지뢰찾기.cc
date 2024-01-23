#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;	cin >> T;

	while (T > 0)
	{
		T--;
		int N;	cin >> N; // 배열 크기
		string num;	cin >> num; // 숫자 문자열
		string bomb;	cin >> bomb; // 지뢰 문자열

		vector<int> numArr(N);

		for (int i = 0; i < N; i++) {
			numArr[i] = stoi(num.substr(i, 1));
		}

		int result = 0;

		for (int i = 0; i < N; i++) {
			if (bomb[i] == '*') {
				result++;

				numArr[i]--;
				if (i + 1 < N)
					numArr[i + 1]--;
				if (0 <= i - 1)
					numArr[i - 1]--;
			}
		}

		for (int i = 0; i < N; i++) {
			if (i == 0) {
				if (numArr[i] != 0 && numArr[i + 1] != 0) {
					numArr[i]--;
					numArr[i + 1]--;
					result++;
				}
			}
			else if (i == N - 1) {
				if (numArr[i] != 0 && numArr[i - 1] != 0) {
					numArr[i]--;
					numArr[i - 1]--;
					result++;
				}
			}
			else {
				if (numArr[i] != 0 && numArr[i - 1] != 0 && numArr[i + 1] != 0) {
					numArr[i]--;
					numArr[i - 1]--;
					numArr[i + 1]--;
					result++;
				}
			}
		}

		cout << result << "\n";
	}

}