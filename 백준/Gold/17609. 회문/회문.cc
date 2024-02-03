#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int palindromeTest(int left, int right, bool isDelete, string test) {

	while (left < right)
	{
		if (test[left] != test[right]) { // 펠린드롬이 아닌 경우
			if (isDelete) // 이미 삭제한 경우
				return 2;
			else {
				if (palindromeTest(left + 1, right, true, test) == 0 || // 왼쪽 부분 삭제
					palindromeTest(left, right - 1, true, test) == 0) // 오른쪽 부분 삭제
					return 1; // 삭제해서 되면 1리턴
				else
					return 2; // 2개다 삭제해도 안되면 2 리턴
			}
		}
		left++;
		right--;
	}

	// 펠린드롬 검사 통과
	return 0;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;	cin >> T;

	while (T > 0)
	{
		T--;

		string test;	cin >> test;
		int left = 0;
		int right = test.size() - 1;

		cout << palindromeTest(left, right, false, test) << "\n";
	}
}