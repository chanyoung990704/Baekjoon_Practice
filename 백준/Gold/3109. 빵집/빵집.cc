#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int dy[3] = { -1,0,1 };
int dx[3] = { 1,1,1 };

bool dfs(vector<string>& map, vector<vector<bool>>& visited, int R, int C, int y, int x, int& cnt) {

	if (x == C - 1) { // 열에 도착했으면
		cnt++;
		return true;
	}

	visited[y][x] = true;

	for (int i = 0; i < 3; i++) {
		int nextY = y + dy[i];	int nextX = x + dx[i];
		if (nextY >= 0 && nextY < R && nextX >= 0 && nextX < C) {
			if (!visited[nextY][nextX] && map[nextY][nextX] != 'x')
				if (dfs(map, visited, R, C, nextY, nextX, cnt))
					return true;
		}
	}


	return false;
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int R;	cin >> R; // 행
	int C;	cin >> C; // 열

	vector<string> map(R);
	for (int i = 0; i < R; i++)
		cin >> map[i];

	vector<vector<bool>> visited(R, vector<bool>(C, false));
	int cnt = 0;

	for (int i = 0; i < R; i++)
		dfs(map, visited, R, C, i, 0, cnt);

	cout << cnt << "\n";

}