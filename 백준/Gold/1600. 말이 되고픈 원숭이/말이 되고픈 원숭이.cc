#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>
#include <queue>

using namespace std;

int dy[4] = { 0,0,1,-1 };
int dx[4] = { 1,-1,0,0 };

int hdy[8] = { 1,-1,2,-2,2,-2,1,-1 };
int hdx[8] = { -2,-2,-1,-1,1,1,2,2 };

int bfs(vector<vector<int>>& map, vector<vector<vector<bool>>>& visited, int K, int W, int H) {

	visited[0][0][0] = true;
	queue<tuple<int, int, int, int>> q;
	q.push(make_tuple(0, 0, 0, 0));

	while (!q.empty())
	{
		int curY = get<0>(q.front());	int curX = get<1>(q.front());	int cnt = get<2>(q.front());	int kCnt = get<3>(q.front());
		q.pop();

		// 도착시 리턴
		if (curY == H - 1 && curX == W - 1)
			return cnt;

		// 동서남북 
		for (int i = 0; i < 4; i++) {
			int nextY = curY + dy[i];	int nextX = curX + dx[i];
			if (nextY >= 0 && nextY < H && nextX >= 0 && nextX < W) {
				if (!visited[nextY][nextX][kCnt] && map[nextY][nextX] == 0) {
					visited[nextY][nextX][kCnt] = true;
					q.push(make_tuple(nextY, nextX, cnt + 1, kCnt));
				}
			}

		}


		// 말
		for (int i = 0; i < 8; i++) {
			int nextY = curY + hdy[i];	int nextX = curX + hdx[i];
			if (nextY >= 0 && nextY < H && nextX >= 0 && nextX < W) {
				if (!visited[nextY][nextX][kCnt + 1] && map[nextY][nextX] == 0 && kCnt < K) {
					visited[nextY][nextX][kCnt + 1] = true;
					q.push(make_tuple(nextY, nextX, cnt + 1, kCnt + 1));
				}
			}

		}

	}


	return -1;
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int K;	cin >> K;
	int W, H;	cin >> W >> H;

	vector<vector<int>> map(H, vector<int>(W, 0));
	vector<vector<vector<bool>>> visited(H, vector<vector<bool>>(W, vector<bool>(K + 1, false)));

	for (int i = 0; i < H; i++)
		for (int j = 0; j < W; j++)
			cin >> map[i][j];

	cout << bfs(map, visited, K, W, H);
}
