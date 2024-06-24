#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool is_watched_s(int y, int x, int dir, vector<vector<char>>& adj) {

    // dir = 1 위쪽
    if(dir == 1) {
        while(y >= 0) {
            char cur = adj[y][x];
            if(cur == 'S')
                return true;
            if(cur == 'O')
                break;
            y--;
        }
    }

    // dir = 2 아래쪽
    else if(dir == 2) {
        while(y < adj.size()) {
            char cur = adj[y][x];
            if(cur == 'S')
                return true;
            if(cur == 'O')
                break;
            y++;
        }
    }

    // dir = 3 왼쪽

    else if(dir == 3) {
        while(x >= 0) {
            char cur = adj[y][x];
            if(cur == 'S')
                return true;
            if(cur == 'O')
                break;
            x--;
        }
    }

    // dir = 4 오른쪽
    else if(dir == 4) {
        while(x < adj[0].size()) {
            char cur = adj[y][x];
            if(cur == 'S')
                return true;
            if(cur == 'O')
                break;
            x++;
        }
    }


    return false;
}

bool possible_all_teacher(vector<vector<char>>& adj, vector<pair<int, int>>& T_adj) {

    for(auto& cur : T_adj) {
        
        for(int i = 1 ; i <= 4 ; i++)
            if(is_watched_s(cur.first, cur.second, i, adj))
                return false;

    }

    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int N;  cin >> N;

    vector<vector<char>> adj(N, vector<char>(N));
    vector<pair<int, int>> T_adj;
    vector<pair<int, int>> blank_adj;
    for(int i = 0 ; i < N ; i++)
        for(int j = 0 ; j < N ; j++) {
            cin >> adj[i][j];

            char cur = adj[i][j];
            if(cur == 'T')
                T_adj.push_back(make_pair(i, j));
            else if(cur == 'X')
                blank_adj.push_back(make_pair(i, j));
        }


    // 빈칸 3개 조합
    vector<bool> visited(blank_adj.size(), false);
    fill(visited.begin(), visited.begin() + 3, true);

    do{
        for(int i = 0 ; i < visited.size() ; i++)
            if(visited[i]) {
                int y = blank_adj[i].first;
                int x = blank_adj[i].second;

                adj[y][x] = 'O';
            }

        if(possible_all_teacher(adj, T_adj)){
            cout << "YES";
            return 0;
        }

        for(int i = 0 ; i < visited.size() ; i++)
            if(visited[i]) {
                int y = blank_adj[i].first;
                int x = blank_adj[i].second;

                adj[y][x] = 'X';
            }



    }while(prev_permutation(visited.begin(), visited.end()));


    cout << "NO";
    return 0;
}