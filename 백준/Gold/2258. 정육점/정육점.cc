#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool cmp(pair<long long, long long> a, pair<long long, long long >b) {
	if (a.first == b.first)
		return a.second > b.second;
	else
		return a.first < b.first;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N; // 덩어리 개수
	long long M;	cin >> M; // 필요한 고기 양

	vector<pair<long long, long long>> v(N);
	for (int i = 0; i < N; i++) {
		long long weight;	cin >> weight;
		long long price;	cin >> price;
		v[i] = make_pair(price, weight);
	}

	sort(v.begin(), v.end(), cmp);

	long long totalW = 0; // 현재 구매한 총 무게
	long long totalP = 0; // 현재 구매에 쓰인 가격
	long long prev = 0;

	for (auto r : v) {

		if (totalW < M) { // 구매가 필요한 상황

			if (r.first == prev) { // 가격이 같은 것이 여러 개 있는 경우
				totalP += r.first;
			}
			else {
				totalP = r.first;
				prev = r.first;
			}

		}
		else { // 구매가 필요하지는 않지만 가격이 같은 것 여러개 사는 것과 비싼 것 사는 것 비교하는 과정

			if (prev < r.first && totalP >= r.first) {
				prev = r.first;
				totalP = r.first;
			}

		}

		totalW += r.second;
	}

	if (totalW < M)
		cout << "-1\n";
	else
		cout << totalP << "\n";

}
