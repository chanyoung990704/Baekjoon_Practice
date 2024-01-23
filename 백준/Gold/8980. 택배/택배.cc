#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>

using namespace std;

bool compare(tuple<int, int, int> a, tuple<int, int, int> b) {

	if (get<1>(a) == get<1>(b))
		return get<0>(a) > get<0>(b);
	else
		return get<1>(a) < get<1>(b);
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N; // 마을 수
	int C;	cin >> C; // 트럭 용량
	int M;	cin >> M; // 박스 개수

	vector<tuple<int, int, int>> boxDetail;

	for (int i = 0; i < M; i++) {
		int from;	cin >> from;
		int to;		cin >> to;
		int boxes;	cin >> boxes;

		boxDetail.push_back(make_tuple(from, to, boxes));
	}

	sort(boxDetail.begin(), boxDetail.end(), compare);

	vector<int> loaded(N + 1, 0); // 현재 택배에 실어진 상자 수
	int result = 0;

	for (int i = 0; i < M; i++) {
		int from = get<0>(boxDetail[i]);	int to = get<1>(boxDetail[i]);	int boxes = get<2>(boxDetail[i]);
		int maxloaded = *max_element(loaded.begin() + from, loaded.begin() + to);
		int tmp = min(boxes, C - maxloaded);
		result += tmp;

		for (int j = from; j < to; j++)
			loaded[j] += tmp;

	}

	cout << result << "\n";
	
}