#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N; // 도시 숫자
	
	vector<long long> distance(N - 1); // 도시 간 거리
	vector<long long> price(N); // 도시 주유 가격
	long long totalDistance = 0;

	for (int i = 0; i < N - 1; i++)
	{
		cin >> distance[i];
		totalDistance += distance[i];
	}

	for (int i = 0; i < N; i++)
		cin >> price[i];

	vector<tuple<long long, int, long long>> priceDistance;

	for (int i = 0; i < N - 1; i++)
	{
		priceDistance.push_back(make_tuple(price[i], i, totalDistance));
		totalDistance -= distance[i];
	}

	sort(priceDistance.begin(), priceDistance.end());

	int idx = 987654321;
	long long tmpDistance = 0;
	long long result = 0;

	for (auto c : priceDistance) {
		if (idx == 0) // 도착했으면
			break;

		long long curPrice = get<0>(c);	int curIdx = get<1>(c);	long long curTotalDistance = get<2>(c);
		
		if (idx < curIdx) // 이미 고려된 결과라면 스킵
			continue;

		result += curPrice * (curTotalDistance - tmpDistance);
		tmpDistance = curTotalDistance;
		idx = curIdx;
	}

	cout << result << "\n";
}