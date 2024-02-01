#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>

using namespace std;

bool comp(tuple<int, int, int> a, tuple<int, int, int> b) {
	return abs(get<1>(a) - get<2>(a)) > abs(get<1>(b) - get<2>(b));
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (true) {

		int N;	cin >> N; // 전체 팀 숫자
		int A;	cin >> A; // A풍선 개수
		int B;	cin >> B; // B풍선 개수

		if (N == 0 && A == 0 && B == 0)
			break;

		vector<tuple<int, int, int>> info(N); // 풍선 개수, A 방과 거리, B방과 거리
		for (int i = 0; i < N; i++) {
			int balloons;	cin >> balloons;
			int distanceA;	cin >> distanceA;
			int distanceB;	cin >> distanceB;
			info[i] = make_tuple(balloons, distanceA, distanceB);
		}

		sort(info.begin(), info.end(), comp);

		int result = 0;

		for (auto i : info)
		{
			int balloons = get<0>(i);	int distanceA = get<1>(i);	int distanceB = get<2>(i);
			int minDistance = min(distanceA, distanceB);

			if (minDistance == distanceA) { // A가 최소 거리일 때
				if (A >= balloons) { // 최소 거리에 충분한 풍선이 있는 경우
					result += balloons * distanceA;
					A -= balloons;
				}
				else {
					if (A > 0) {
						result += A * distanceA;
						result += (balloons - A) * distanceB;
						B -= (balloons - A);
						A = 0;

					}
					else {
						result += balloons * distanceB;
						B -= balloons;
					}

				}
			}
			else { // B가 최소 거리일 때
				if (B >= balloons) { // 최소 거리에 충분한 풍선이 있는 경우
					result += balloons * distanceB;
					B -= balloons;
				}
				else {
					if (B > 0) {
						result += B * distanceB;
						result += (balloons - B) * distanceA;
						A -= (balloons - B);
						B = 0;
					}
					else {
						result += balloons * distanceA;
						A -= balloons;
					}
				}
			}

		}

		cout << result << "\n";
	}

}