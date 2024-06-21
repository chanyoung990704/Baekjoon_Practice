#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

bool isPossible(int y, int x, int N){
    return x >= 0 && x < N && y >= 0 && y < N;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;  cin >> N;
    int K;  cin >> K;

    vector<vector<int>> adj(N, vector<int>(N));
    vector<pair<int, pair<int, int>>> virus_idx; 
    for(int i = 0 ; i < N ; i++)
        for(int j = 0 ; j < N ; j++){
            cin >> adj[i][j];
            if(adj[i][j] != 0)
                virus_idx.push_back(make_pair(adj[i][j], make_pair(i, j)));
        }

    int S;  cin >> S;
    int Y;  cin >> Y;
    int X;  cin >> X;

    
    sort(virus_idx.begin(), virus_idx.end());

    
    // BFS

    // vector<vector<bool>> visited(N, vector<bool>(N, false));
    queue<pair<int, pair<int, int>>> q;  // <cnt, y, x>

    for(auto& virus : virus_idx)
        q.push(make_pair(0, make_pair(virus.second.first, virus.second.second)));

    while(!q.empty()) {

        int cur_y = q.front().second.first;
        int cur_x = q.front().second.second;
        int cur_time = q.front().first;

        if(cur_time == S)
            break;

        q.pop();

        for(int i = 0 ; i < 4 ; i++) {
            int ny = cur_y + dy[i];
            int nx = cur_x + dx[i];

            if(isPossible(ny, nx, N) && adj[ny][nx] == 0) {
                adj[ny][nx] = adj[cur_y][cur_x];
                q.push(make_pair(cur_time + 1, make_pair(ny, nx)));
            }
        }

    }

    // cout << "----------------\n";

    // for(int i = 0 ; i < N ; i++){
    //     for(int j = 0 ; j < N ; j++)
    //         cout << adj[i][j] << " ";
    //     cout << "\n";
    // } 

    cout << adj[Y - 1][X - 1] << "\n";
}