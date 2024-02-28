#include <algorithm>
#include <iostream>
#include <math.h>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	vector<int> nums(N);
	int MAX = -1;

	for (int i = 0; i < N; i++)
	{
		cin >> nums[i];
		MAX = max(MAX, nums[i]);
	}

	// N까지의 에라토스테네스의 체를 만든다.
	vector<int> minFactor(MAX + 1);
	for (int i = 2; i <= MAX; i++)
		minFactor[i] = i;

	int sqrtn = int(sqrt(MAX));
	for (int i = 2; i <= sqrtn; i++) {
		if (minFactor[i] == i) {
			for (int j = i * i; j <= MAX; j += i)
				if (minFactor[j] == j)
					minFactor[j] = i;
		}
	}

	for (int T : nums) {
		vector<int> result;
		while (T > 1)
		{
			result.push_back(minFactor[T]);
			T /= minFactor[T];
		}

		for (int n : result)
			cout << n << " ";

		cout << "\n";
	}

}