#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;	cin >> N >> M;
	vector<int> arr(N);
	for (int i = 0; i < N; i++)
		cin >> arr[i];

	// 투포인터
	int lo = 0, hi = 0;
	long long sum = 0;
	int result = 0;
	while (true)
	{
		// M보다 같거나 크면 lo 증가
		if (sum >= M)
			sum -= arr[lo++];
		// hi가 배열의 끝에 다다르면 종료
		else if (hi == N)
			break;
		else
			sum += arr[hi++];

		// 결과 갱신
		if (sum == M)
			result++;


	}


	cout << result << "\n";

}