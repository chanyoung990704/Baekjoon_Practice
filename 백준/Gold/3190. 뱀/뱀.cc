#include <algorithm>
#include <iostream>
#include <vector>
#include <set>
#include <queue>
#include <deque>

using namespace std;

pair<int, int> dydx[4] = {make_pair(0, 1), make_pair(1, 0), make_pair(0, -1), make_pair(-1, 0)};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;  cin >> N;

    vector<vector<int>> board(N + 1, vector<int>(N + 1, 0));

    int K;  cin >> K;
    for(int i = 0 ; i < K ; i++){
        int y, x;    cin >> y >> x;
        board[y][x] = 1;
    }

    priority_queue<pair<int, int>, vector<pair<int,int>>, greater<pair<int, int>>> pq;
    int L;  cin >> L;
    for(int i = 0 ; i < L ; i++) {
        int t;  cin >> t;
        char dir;   cin >> dir;
        if(dir == 'D')
            pq.push(make_pair(t, 1));
        else if(dir == 'L')
            pq.push(make_pair(t, -1));
    }

    int cur_t = 0;
    deque<pair<int, int>> snake;
    snake.push_back(make_pair(1, 1));
    int cur_dir = 0;

    while(true) {
        // 방향 수정
        if(!pq.empty() && pq.top().first == cur_t) {
            cur_dir = (cur_dir + pq.top().second + 4) % 4; // 방향을 0~3으로 유지
            pq.pop();
        }

        // 다음 상태로 이동
        cur_t++;
        
        int ny = snake.front().first + dydx[cur_dir].first;
        int nx = snake.front().second + dydx[cur_dir].second;

        // 벽에 부딪히는 경우
        if(ny < 1 || ny > N || nx < 1 || nx > N){
            break;
        }

        bool isPossible = true;
        // 자기 자신의 몸과 부딪히는 경우
        for(auto &part : snake) {
            if(part.first == ny && part.second == nx) {
                isPossible = false;
                break;
            }
        }

        if(!isPossible)
            break;

        // 이동
        snake.push_front(make_pair(ny, nx));

        // 사과 있는 경우
        if(board[ny][nx] == 1){
            board[ny][nx] = 0; // 사과를 먹음
        } else {
            snake.pop_back(); // 사과가 없으면 꼬리를 줄임
        }
    }

    cout << cur_t << '\n';
    return 0;
}