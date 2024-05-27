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
    int K;  cin >> K;

    vector<int> dist(100000 + 1, 1e9);

    // 우선순위 큐 사용
    deque<int> dq;
    dist[N] = 0;
    dq.push_front(N);


    while(!dq.empty()){

        int cur = dq.front();
        dq.pop_front();

        if(cur == K){
            cout << dist[cur];
            return 0;
        }

        // 2배로
        if(cur * 2 < dist.size() && dist[cur * 2] > dist[cur]){
            dist[cur * 2] = dist[cur];
            dq.push_front(cur * 2);
        }

        if(cur + 1 < dist.size() && dist[cur + 1] > dist[cur] + 1){
            dist[cur + 1] = dist[cur] + 1;
            dq.push_back(cur + 1);
        }

        if(cur - 1 >= 0 && dist[cur - 1] > dist[cur] + 1){
            dist[cur - 1] = dist[cur] + 1;
            dq.push_back(cur - 1);
        }



    }

    return 0;

}