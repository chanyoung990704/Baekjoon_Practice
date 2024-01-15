#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int dy[4] = { 0,0,-1,1 };
int dx[4] = { 1,-1,0,0 };

void dfs(vector<vector<char>>& adj, vector<bool>& alphabetVisited, vector<vector<bool>>& adjVisited,
	int y, int x, int R, int C, int cnt, int& result) {
	
	if (cnt > result)
		result = cnt;

	alphabetVisited[adj[y][x] - 'A'] = true;
	adjVisited[y][x] = true;

	for (int i = 0; i < 4; i++) {
		int nextY = y + dy[i];	int nextX = x + dx[i];
		if(nextY >= 0 && nextY < R && nextX >= 0 && nextX < C)
			if (!alphabetVisited[adj[nextY][nextX] - 'A'] && !adjVisited[nextY][nextX]) {
				alphabetVisited[adj[nextY][nextX] - 'A'] = true;
				adjVisited[nextY][nextX] = true;
				dfs(adj, alphabetVisited, adjVisited, nextY, nextX, R, C, cnt + 1, result);
				alphabetVisited[adj[nextY][nextX] - 'A'] = false;
				adjVisited[nextY][nextX] = false;
			}

	}



}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int R;	cin >> R;
	int C;	cin >> C;

	vector<vector<char>> adj(R, vector<char>(C, ' '));

	for (int i = 0; i < R; i++)
		for (int j = 0; j < C; j++)
			cin >> adj[i][j];

	vector<bool> alphabetVisited(26, false);
	vector<vector<bool>> adjVisited(R, vector<bool>(C, false));

	int result = 0;

	dfs(adj, alphabetVisited, adjVisited, 0, 0, R, C, 1, result);

	cout << result << "\n";


}