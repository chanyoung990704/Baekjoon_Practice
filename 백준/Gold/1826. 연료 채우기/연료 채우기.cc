#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	vector<pair<int, int>> oilStation(N); // 주유소 거리, 연료량

	for (int i = 0; i < N; i++)
	{
		int distance;	cin >> distance;
		int oils;	cin >> oils;
		oilStation[i] = make_pair(distance, oils);
	}

	int totalDistance;	cin >> totalDistance; // 전체 이동해야할 거리
	int curOils;	cin >> curOils; // 현재 보유 기름 양

	sort(oilStation.begin(), oilStation.end());
	priority_queue<int> q;
	int cnt = 0;
	bool isPossible = true;
	for (pair<int, int> status : oilStation) {
		if (curOils >= totalDistance)
			break;
		
		if (status.first <= curOils)
		{
			q.push(status.second);
		}
		else {
			// 기름 채우기
			while (!q.empty() && curOils < status.first)
			{
				curOils += q.top();
				q.pop();
				cnt++;
			}
			if (curOils < status.first)
			{
				isPossible = false;
				break;
			}
			else
				q.push(status.second);
		}

		if (status.first == oilStation[N - 1].first) { // 마지막
			while (!q.empty() && curOils < totalDistance)
			{
				cnt++;
				curOils += q.top();
				q.pop();
			}

			if (curOils < totalDistance)
				isPossible = false;
		}

	}

	if (isPossible)
		cout << cnt << "\n";
	else
		cout << "-1\n";

}