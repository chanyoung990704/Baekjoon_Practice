#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int dy[4] = { 0,0,-1,1 };
int dx[4] = { 1,-1,0,0 };

void dfs(int R, int C, int K, vector<string>& map, vector<vector<bool>>& visited, int y, int x, int distance, int& cnt) {

	if (y == 0 && x == C - 1) { // 도착했으면
		if (distance == K)
			cnt++;
		return;
	}

	visited[y][x] = true;

	for (int i = 0; i < 4; i++) {

		int nextY = y + dy[i];	int nextX = x + dx[i];
		if (nextY >= 0 && nextY < R && nextX >= 0 && nextX < C) { // 다음 범위에 들어간다면
			if (!visited[nextY][nextX] && map[nextY][nextX] != 'T') {
				visited[nextY][nextX] = true;
				dfs(R, C, K, map, visited, nextY, nextX, distance + 1, cnt);
				visited[nextY][nextX] = false;
			}

		}

	}


}




int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int R;	cin >> R; // y
	int C;	cin >> C; // x
	int K;	cin >> K; // 거리

	vector<string> map(R);
	vector<vector<bool>> visited(R, vector<bool>(C, false));

	for (int i = 0; i < R; i++)
		cin >> map[i];

	int cnt = 0;
	dfs(R, C, K, map, visited, R - 1, 0, 1, cnt);

	cout << cnt << "\n";
}