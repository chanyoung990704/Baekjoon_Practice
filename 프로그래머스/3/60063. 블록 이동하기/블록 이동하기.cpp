#include <string>
#include <vector>
#include <set>
#include <algorithm>
#include <queue>
#include <tuple>

using namespace std;

int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

bool is_possible(int y, int x, vector<vector<int>>& board){
    return (y >= 0 && y < board.size() && x >= 0 && x < board[0].size()) &&
        (board[y][x] != 1);
}

int solution(vector<vector<int>> board) {
    int n = board.size();
    set<pair<pair<int, int>, pair<int, int>>> s; // visited 대용
    
    queue<tuple<int, int, int, int, int>> q;
    q.push(make_tuple(0, 0, 0, 1, 0));
    s.insert(make_pair(make_pair(0, 0), make_pair(0, 1)));
    
    while(!q.empty()) {
        int y1 = get<0>(q.front()); int x1 = get<1>(q.front());
        int y2 = get<2>(q.front()); int x2 = get<3>(q.front());
        int cnt = get<4>(q.front());
        q.pop();
        
        if((y1 == n-1 && x1 == n-1) || (y2 == n-1 && x2 == n-1))
            return cnt;
        
        // 상하좌우 이동
        for(int i = 0 ; i < 4 ; i++){
            int ny1 = y1 + dy[i];   int nx1 = x1 + dx[i];
            int ny2 = y2 + dy[i];   int nx2 = x2 + dx[i];
            
            if(is_possible(ny1, nx1, board) && is_possible(ny2, nx2, board)) {
                pair<pair<int, int>, pair<int, int>> new_pos = make_pair(make_pair(ny1, nx1), make_pair(ny2, nx2));
                if(s.find(new_pos) == s.end()) {
                    s.insert(new_pos);
                    q.push(make_tuple(ny1, nx1, ny2, nx2, cnt + 1));
                }
            }
        }
        
        // 회전 이동
        if(y1 == y2) {  // 로봇이 가로 방향일 때
            for(int i : {-1, 1}) {  // 위쪽과 아래쪽 확인
                if(is_possible(y1 + i, x1, board) && is_possible(y2 + i, x2, board)){
                    pair<pair<int, int>, pair<int, int>> new_pos1 = make_pair(make_pair(y1, x1), make_pair(y1 + i, x1));
                    pair<pair<int, int>, pair<int, int>> new_pos2 = make_pair(make_pair(y2, x2), make_pair(y2 + i, x2));
                    
                    if(s.find(new_pos1) == s.end()){
                        s.insert(new_pos1);
                        q.push(make_tuple(y1, x1, y1+i, x1, cnt + 1));
                    }
                    
                    if(s.find(new_pos2) == s.end()) {
                        s.insert(new_pos2);
                        q.push(make_tuple(y2, x2, y2+i, x2, cnt + 1));
                    }
                }
            }
        }
        else if(x1 == x2){  // 세로 방향일 때
            for(int i : {-1, 1}) {  // 왼쪽과 오른쪽 확인
                if(is_possible(y1, x1 + i, board) && is_possible(y2, x2 + i, board)){
                    pair<pair<int, int>, pair<int, int>> new_pos1 = make_pair(make_pair(y1, x1), make_pair(y1, x1 + i));
                    pair<pair<int, int>, pair<int, int>> new_pos2 = make_pair(make_pair(y2, x2), make_pair(y2, x2 + i));
                    
                    if(s.find(new_pos1) == s.end()){
                        s.insert(new_pos1);
                        q.push(make_tuple(y1, x1, y1, x1 + i, cnt + 1));
                    }
                    
                    if(s.find(new_pos2) == s.end()) {
                        s.insert(new_pos2);
                        q.push(make_tuple(y2, x2, y2, x2 + i, cnt + 1));
                    }
                }
            }
        }
    }
    
    return -1; 
}