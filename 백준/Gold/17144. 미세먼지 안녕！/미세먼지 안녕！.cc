#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

bool is_possible(int y, int x, vector<vector<int>>& adj) {
    return y >= 0 && y < adj.size() && x >= 0 && x < adj[0].size();
}

void affect_dirty_air(vector<vector<int>>& adj) {

    vector<pair<int, int>> dirty_air;
    for(int i = 0 ; i < adj.size() ; i++)
        for(int j = 0 ; j < adj[0].size() ; j++)
            if(adj[i][j] != -1 && adj[i][j] != 0)
                dirty_air.push_back(make_pair(i, j));

    vector<vector<int>> cost_adj(adj.size(), vector<int>(adj[0].size(), 0));

    for(auto& cur : dirty_air) {
        int y = cur.first;
        int x = cur.second;

        int select_block = 0;
        for(int i = 0 ; i < 4 ; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(is_possible(ny, nx, adj) && adj[ny][nx] != -1){
                select_block++;
                cost_adj[ny][nx] += (adj[y][x] / 5);
            }

        }

        cost_adj[y][x] -= (adj[y][x] / 5 ) * select_block;
    }

    for(int i = 0 ; i < adj.size() ; i++)
        for(int j = 0 ; j < adj[0].size() ; j++)
            adj[i][j] += cost_adj[i][j];

}

void affect_air_conditional(vector<vector<int>>& adj, vector<pair<int, int>>& air_conditional) {

    // 위쪽 공기청정기
    int y = air_conditional[0].first;
    int x = air_conditional[0].second;

    vector<int> tmp;
    tmp.push_back(0);

    // 오른쪽
    for(int i = x + 1 ; i < adj[0].size() ; i++)
        tmp.push_back(adj[y][i]);
    
    // 위쪽
    for(int i = y - 1 ; i >= 0 ; i--)
        tmp.push_back(adj[i][adj[0].size() - 1]);
    
    // 왼쪽
    for(int i = adj[0].size() - 2 ; i >= 0 ; i--)
        tmp.push_back(adj[0][i]);

    // 아래쪽
    for(int i = 1 ; i < y ; i++)
        tmp.push_back(adj[i][0]);

    int idx = 0;

    // 오른쪽
    for(int i = x + 1 ; i < adj[0].size() ; i++)
        adj[y][i] = tmp[idx++];
    
    // 위쪽
    for(int i = y - 1 ; i >= 0 ; i--)
        adj[i][adj[0].size()-1] = tmp[idx++];
    
    // 왼쪽
    for(int i = adj[0].size() - 2 ; i >= 0 ; i--)
        adj[0][i] = tmp[idx++];

    // 아래쪽
    for(int i = 1 ; i < y ; i++)
        adj[i][0] = tmp[idx++];

}

void affect_air_conditional2(vector<vector<int>>& adj, vector<pair<int, int>>& air_conditional) {

    // 아래쪽 공기청정기
    int y = air_conditional[1].first;
    int x = air_conditional[1].second;

    vector<int> tmp;
    tmp.push_back(0);

    // 오른쪽
    for(int i = x + 1 ; i < adj[0].size() ; i++)
        tmp.push_back(adj[y][i]);

    // 아래쪽
    for(int i = y + 1 ; i < adj.size() ; i++)
        tmp.push_back(adj[i][adj[0].size() - 1]);

    // 왼쪽
    for(int i = adj[0].size() - 2 ; i >= 0 ; i--)
        tmp.push_back(adj[adj.size() - 1][i]);

    // 위쪽
    for(int i = adj.size() - 2 ; i > y ; i--)
        tmp.push_back(adj[i][0]);

    int idx = 0;

    // 오른쪽
    for(int i = x + 1 ; i < adj[0].size() ; i++)
        adj[y][i] = tmp[idx++];

    // 아래쪽
    for(int i = y + 1 ; i < adj.size() ; i++)
        adj[i][adj[0].size() - 1] = tmp[idx++];

    // 왼쪽
    for(int i = adj[0].size() - 2 ; i >= 0 ; i--)
        adj[adj.size() - 1][i] = tmp[idx++];

    // 위쪽
    for(int i = adj.size() - 2 ; i > y ; i--)
        adj[i][0] = tmp[idx++];

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int R;  cin >> R;
    int C;  cin >> C;
    int T;  cin >> T;

    vector<vector<int>> adj(R, vector<int>(C));
    vector<pair<int, int>> air_conditional;
    for(int i = 0 ; i < R ; i++)
        for(int j = 0 ; j < C ; j++){
            cin >> adj[i][j];

            int cur = adj[i][j];
            if(cur == -1)
                air_conditional.push_back(make_pair(i, j));
        }

    // 미세먼지 확산

    for(int i = 0 ; i < T ; i++) {

        affect_dirty_air(adj);
        affect_air_conditional(adj, air_conditional);
        affect_air_conditional2(adj, air_conditional);

    }

    int total = 0;

    for(int i = 0 ; i < adj.size() ; i++){
        for(int j = 0 ; j < adj[0].size() ; j++)
            total += adj[i][j];
    }    

    total += 2; // -1 2번 더한것 복구

    cout << total << "\n";
}