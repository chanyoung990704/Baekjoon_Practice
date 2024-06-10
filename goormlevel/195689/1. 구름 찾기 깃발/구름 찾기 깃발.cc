#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// 상, 하, 좌 우 왼대각 오른대각 왼아래 대각 오른아래 대각
int dy[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
int dx[8] = {0, 0, -1, 1, -1, 1, -1, 1};

bool isPossible(int y, int x, int N){
	return (y >= 0) && (y < N) && (x >= 0) && (x < N);
}

int main() {

	
	int N;	cin >> N;
	int K;	cin >> K;
	
	int result = 0;
	vector<vector<int>> M(N, vector<int>(N));
	
	for(int i = 0 ; i < N ; i++)
		for(int j = 0 ; j < N ; j++)
			cin >> M[i][j];
	
	
	for(int i = 0 ; i < N ; i++)
		for(int j = 0 ; j < N ; j++){
			int cur_y = i;
			int cur_x = j;
			
			int cnt = 0;
			for(int k = 0 ; k < 8 ; k++) {
				int next_y = cur_y + dy[k];
				int next_x = cur_x + dx[k];
				
				if(isPossible(next_y, next_x, N)){
					if(M[next_y][next_x] == 1)
						cnt++;
				}
				
			}
			
			if(M[cur_y][cur_x] != 1 && K == cnt)
				result++;
		}
		
	cout << result << "\n";
	
	return 0;
}