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
	int K;	cin >> K;

	int target = int(sqrt(N));
	vector<int> result;

	for (int i = 1; i <= target; i++)
	{
		if (N % i == 0) {
			result.push_back(i);
			if (N / i == i)
				continue;
			else
				result.push_back(N / i);
		}
	}

	sort(result.begin(), result.end());

	if (result.size() < K)
		cout << 0 << "\n";
	else
		cout << result[K - 1] << "\n";
}