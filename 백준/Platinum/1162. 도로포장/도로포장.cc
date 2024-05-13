#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, K;   cin >> N >> M >> K;

    // 초기화
    vector<vector<pair<int, int>>> adj(N + 1);
    for(int i = 0 ; i < M ; i++){
        int from, to, cost; cin >> from >> to >> cost;
        adj[from].push_back(make_pair(to, cost));
        adj[to].push_back(make_pair(from, cost));
    }

    // 다익스트라 구하기
    int start_idx = 1, finish_idx = N;
    vector<vector<long long>> dist(N + 1, vector<long long>(K + 1, 1e15)); // 최소 거리 배열
    priority_queue<tuple<long long, int, int>, vector<tuple<long long, int, int>>, greater<tuple<long long, int, int>>> pq; // 최소힙 < 거리, 인덱스, 포장 횟수 >
    dist[start_idx][0] = 0;
    pq.push(make_tuple(0, start_idx, 0));

    while(!pq.empty()) {

        long long cur_dist = (get<0>(pq.top()));
        int cur_idx = get<1>(pq.top());
        int cur_cnt = get<2>(pq.top());
        pq.pop();

        // basecase
        if(dist[cur_idx][cur_cnt] < cur_dist)
            continue;

        // 간선 탐색
        for(auto& next : adj[cur_idx]) {
            int next_idx = next.first;
            long long additional_dist = next.second;
            long long total_dist = cur_dist + additional_dist;

            // 포장하지 않는 경우
            if(total_dist < dist[next_idx][cur_cnt]) {
                dist[next_idx][cur_cnt] = total_dist;
                pq.push(make_tuple(total_dist, next_idx, cur_cnt));
            }

            // 포장하는 경우
            if(cur_cnt < K && dist[next_idx][cur_cnt + 1] > cur_dist){
                dist[next_idx][cur_cnt + 1] = cur_dist;
                pq.push(make_tuple(cur_dist, next_idx, cur_cnt + 1));
            }

        }
    }

    long long result = *min_element(dist[finish_idx].begin(), dist[finish_idx].end());

    cout << result << "\n";

    
}