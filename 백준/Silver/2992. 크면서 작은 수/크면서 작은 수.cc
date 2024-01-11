#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int X;	cin >> X;

	// 숫자 분해
	vector<int> numArr;
	int tmp = X;
	while (tmp > 0)
	{
		numArr.push_back(tmp % 10);
		tmp /= 10;
	}

	// 순열돌면서 로직 수행
	sort(numArr.begin(), numArr.end());
	bool isMatch = false;
	int result = 987654321;

	do {
		int numVal = 0;
		int size = numArr.size();

		for (int n : numArr)
			numVal += n * pow(10, --size);

		if (numVal > X) { // X 보다 크고
			if (numVal < result) // 최소값이라면
				result = numVal;
			isMatch = true;
		} 

	} while (next_permutation(numArr.begin(), numArr.end()));

	if (isMatch)
		cout << result << "\n";
	else
		cout << isMatch << "\n";

}

