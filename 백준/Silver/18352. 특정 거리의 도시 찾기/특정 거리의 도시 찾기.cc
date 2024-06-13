#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    

    int N;  cin >> N;
    int M;  cin >> M;
    int K;  cin >> K;
    int X;  cin >> X;

    vector<vector<int>> adj(N + 1);

    for(int i = 0 ; i < M ; i++) {
        int s, e;   cin >> s >> e;
        adj[s].push_back(e);
    }


    //BFS

    vector<int> result;
    vector<bool> visited(N + 1, false);

    queue<pair<int, int>> q;
    q.push(make_pair(X, 0));
    visited[X] = true;

    while(!q.empty()) {
        int cur = q.front().first;
        int cnt = q.front().second;
        q.pop();

        if(cnt == K)
            result.push_back(cur);

        for(auto& next : adj[cur]){
            if(!visited[next]){
                visited[next] = true;
                q.push(make_pair(next, cnt + 1));
            }
        }
    }



    if(result.empty())
        cout << -1;
    else{
        sort(result.begin(), result.end());
        for(auto& r : result)
            cout << r << "\n";
    }


}