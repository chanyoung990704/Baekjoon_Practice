#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	vector<pair<int, string>> priceString; // 가격, 방번호(string)으로 저장한 벡터
	vector<pair<int, int>> priceInt; // 방번호, 가격으로 저장한 벡터

	for (int i = 0; i < N; i++) {
		int val;	cin >> val;
		priceString.push_back(make_pair(val, to_string(i)));
		priceInt.push_back(make_pair(i, val));
	}

	int M;	cin >> M; // 보유 잔액
	if (N == 1) {
		cout << "0\n";
		return 0;
	}

	sort(priceString.begin(), priceString.end());

	// 가장 싼 금액을 최대한 사용해서 최대 길이 만들기
	string result = "";
	int searchPrice = priceString[0].first;

	if (priceString[0].second == "0") { // 0번 방이 가장 싼 금액인 경우
		// 그 다음으로 싼 방을 1개 추가한다.
		if (M >= priceString[1].first) {
			result += priceString[1].second;
			M -= priceString[1].first;
		}
		else
		{
			result += priceString[0].second;
			M -= priceString[0].first;
		}
	}

	while (M >= searchPrice && result[0] != '0')
	{
		result += priceString[0].second;
		M -= priceString[0].first;
	}

	// 최대길이의 첫번째 요소부터 N에 가까운 번호로 바꾸기
	int idx1 = 0;
	while (M >= 0 && idx1 < result.size() && result[0] != '0')
	{
		char char_num = result[idx1];
		string str_num(1, char_num);
		int curIdx = stoi(str_num);

		int curPrice = priceInt[curIdx].second;
		for (int i = N - 1; i > curIdx; i--) {
			int nextPrice = priceInt[i].second;
			if (M - (nextPrice - curPrice) >= 0)
			{
				M -= (nextPrice - curPrice);
				result[idx1] = '0' + i;
				break;
			}
		}

		idx1++;
	}

	cout << result << "\n";

}
