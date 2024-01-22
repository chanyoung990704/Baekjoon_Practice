#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int K;	cin >> K;

	int result = 0;
	int i = 0;

	while (result < K)
	{
		result = pow(2, i);
		i++;
	}

	int cnt = 0;

	if (result == K)
		cout << K << " " << cnt << "\n";
	else // result > K 일때
	{
		int tmp = result;

		while (K > 0)
		{
			int s = K - result / 2;
			if (s < 0) {
				cnt++;
				result /= 2;
				continue;
			}
			else {
				K = s;
				result /= 2;
				cnt++;
			}
		}

		cout << tmp << " " << cnt << "\n";
	}

}