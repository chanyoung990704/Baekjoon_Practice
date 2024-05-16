#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;  cin >> N; // 1 ~ N - 1까지 기본 혹은 중간 부품, N이 완제품
    int M;  cin >> M;

    // 위상정렬


    // 진입차수 배열
    vector<int> in_degree(N + 1, 0);
    // 간선 배열
    vector<vector<pair<int, int>>> adj(N + 1);
    // 기본 부품 배열
    vector<int> basic(N + 1, 0);
    // 결과 배열
    vector<vector<int>> result(N + 1, vector<int>(N + 1, 0));
    
    // M 순회
    for(int i = 0 ; i < M ; i++) {
        int X, Y, K;    cin >> X >> Y >> K;

        // 간선 추가
        adj[Y].push_back(make_pair(X, K));
        // 진입차수 갱신
        in_degree[X]++;
    }

    // 위상정렬 큐 생성 & 진입차수 0인거 푸시
    queue<int> q;
    for(int i = 1 ; i <= N ; i++)
        if(in_degree[i] == 0){
            q.push(i);
            basic[i] = 1;
            result[i][i] = 1;
        }

    // 큐 순회
    while(!q.empty()) {

        int cur_idx = q.front();
        q.pop();

        // 진입차수 갱신 & 필요 부품 갱신
        for(auto next : adj[cur_idx]){
            int next_idx = next.first;
            int next_cnt = next.second;

            // 부품 갱신
            for(int i = 1 ; i <= N ; i++) {
                result[next_idx][i] += result[cur_idx][i] * next_cnt;
            }

            if(--in_degree[next_idx] == 0)
                q.push(next_idx);
            
        }
    }

    // 결과출력

    // 기본부품이면 출력
    for(int i =1 ; i <= N ; i++)
        if(basic[i])
            cout << i << " " << result[N][i] << "\n";

}