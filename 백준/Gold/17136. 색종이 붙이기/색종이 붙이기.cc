#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int ans = 987654321;

bool isPossible(vector<vector<int>>& map, int y, int x, int size) {
	for (int i = y; i < y + size; i++) {
		for (int j = x; j < x + size; j++) {
			if (i >= 10 || j >= 10 || map[i][j] == 0) return false;
		}
	}
	return true;
}

void solve(vector<vector<int>>& map, vector<int>& paper, int y, int x, int cnt) {
	if (x == 10) {
		solve(map, paper, y + 1, 0, cnt);
		return;
	}
	if (y == 10) {
		ans = min(ans, cnt);
		return;
	}
	if (map[y][x] == 0) {
		solve(map, paper, y, x + 1, cnt);
	}
	else {
		for (int size = 5; size >= 1; size--) {
			if (paper[size] > 0 && isPossible(map, y, x, size)) {
				paper[size]--;
				for (int i = y; i < y + size; i++) {
					for (int j = x; j < x + size; j++) {
						map[i][j] = 0;
					}
				}
				solve(map, paper, y, x + 1, cnt + 1);
				paper[size]++;
				for (int i = y; i < y + size; i++) {
					for (int j = x; j < x + size; j++) {
						map[i][j] = 1;
					}
				}
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<int> paper(6, 5); // 1 x 1 ~ 5 x 5 색종이 개수
	vector<vector<int>> map(10, vector<int>(10, 0));

	for (int i = 0; i < 10; i++)
		for (int j = 0; j < 10; j++)
			cin >> map[i][j];

	solve(map, paper, 0, 0, 0);

	if (ans == 987654321)
		cout << "-1" << "\n";
	else
		cout << ans << "\n";

	return 0;
}
