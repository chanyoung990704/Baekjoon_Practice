#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>
#include <queue>

using namespace std;

bool bfs(vector<vector<pair<int, long long>>>& adj, long long mid, int factory1, int factory2){

    queue<int> q; // cur weight
    vector<bool> visited(adj.size() + 1, false);

    q.push(factory1);
    visited[factory1] = true;

    while(!q.empty()) {

        int cur = q.front();
        q.pop();

        if(cur == factory2)
            return true;

        for(auto next : adj[cur])
            if(!visited[next.first] && next.second >= mid) {
                visited[next.first] = true;
                q.push(next.first);
            }


    }


    return false;
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;  cin >> N;
    int M;  cin >> M;

    vector<vector<pair<int, long long>>> adj(N + 1); // [from] <to, weight>
    for(int i = 0 ; i < M ; i++) {
        int from, to;
        long long weight;
        cin >> from >> to >> weight;
        adj[from].push_back(make_pair(to, weight));
        adj[to].push_back(make_pair(from, weight));
    }

    int factory1, factory2;  cin >> factory1 >> factory2;

    long long lo = 1, hi = 1000000000;
    long long res = 0;

    while(lo <= hi) {

        long long mid = (lo + hi) / 2;

        if(bfs(adj, mid, factory1, factory2)){
            res = mid;
            lo = mid + 1;
        }else{
            hi = mid - 1;
        }
    }

    cout << res << '\n';

}