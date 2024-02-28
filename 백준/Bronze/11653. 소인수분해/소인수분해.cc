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

	vector<int> minFactor(N + 1, 0);
	for (int i = 2; i <= N; i++)
		minFactor[i] = i;

	// 에라토스테네스의 체를 수행한다.
	int sqrtn = int(sqrt(N));
	for (int i = 2; i <= sqrtn; i++) {
		if (minFactor[i] == i) {
			for (int j = i * i; j <= N; j += i)
				if (minFactor[j] == j)
					minFactor[j] = i;
		}
	}

	// N의 소수를 구한다
	vector<int> result;
	while (N > 1)
	{
		result.push_back(minFactor[N]);
		N /= minFactor[N];
	}

	sort(result.begin(), result.end());
	
	for (int n : result)
		cout << n << "\n";
}