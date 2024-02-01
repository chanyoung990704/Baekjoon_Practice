#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	vector<int> numArr(N);

	for (int i = 0; i < N; i++)
		cin >> numArr[i];

	vector<int> result;
	result.push_back(numArr[0]);

	for (int num : numArr) {
		int lo = 0;
		int hi = result.size();
		int target = num;

		while (lo < hi)
		{
			int mid = (lo + hi) / 2;
			if (result[mid] < target)
				lo = mid + 1;
			else
				hi = mid;
		}

		if (lo == result.size())
			result.push_back(num);
		else {
			if (result[lo] > num)
				result[lo] = num;
		}

	}

	cout << result.size() << "\n";
}