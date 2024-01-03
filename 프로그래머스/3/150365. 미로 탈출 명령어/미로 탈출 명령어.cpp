#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>
#include <queue>

using namespace std;

char direction[4] = { 'd', 'l', 'r', 'u' };
int dy[4] = { 1, 0, 0, -1 };
int dx[4] = { 0, -1, 1, 0 };

string BFS(const int& n, const int& m, int x, int y, const int& r, const int& c, const int& k) {

	vector<vector<vector<bool>>> visited(n, vector<vector<bool>>(m, vector<bool>(k + 1, false)));

	queue<tuple<int, int, string, int>> q;
	q.push(make_tuple(x - 1, y - 1, "", 0));
	visited[x - 1][y - 1][0] = true;

	while (!q.empty()) {
		int curY = get<0>(q.front());
		int curX = get<1>(q.front());
		string path = get<2>(q.front());
		int cnt = get<3>(q.front());

		q.pop();

		// 도착했으면 return
		if (curY == r - 1 && curX == c - 1 && cnt == k) {
			return path;
		}

		// 하좌우상 탐색
		for (int i = 0; i < 4; i++) {
			int nextY = curY + dy[i];
			int nextX = curX + dx[i];
			string nextPath = path + direction[i];
			int nextCnt = cnt + 1;
			
			if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && nextCnt <= k && !visited[nextY][nextX][nextCnt]) {
				q.push(make_tuple(nextY, nextX, nextPath, nextCnt));
				visited[nextY][nextX][nextCnt] = true;
			}

		}
	}

	return "impossible";

}

string solution(int n, int m, int x, int y, int r, int c, int k) {
    string answer = BFS(n,m,x,y,r,c,k);
    return answer;
}