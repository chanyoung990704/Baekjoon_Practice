#include <vector>
#include <queue>
#include <algorithm>
#include <tuple>
using namespace std;

int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

int bfs(vector<vector<int>>& map) {
    // 방문 배열
    vector<vector<bool>> visited(map.size(),
                                 vector<bool>(map[0].size(), false));
    visited[0][0] = true;
    // 큐
    queue<tuple<int,int,int>> q;
    // 시작 좌표 0,0 그리고 cnt
    q.push(make_tuple(0, 0, 1));
    
    while(!q.empty()) {
        
        int curY = get<0>(q.front());   int curX = get<1>(q.front());
        int cnt = get<2>(q.front());
        q.pop();
        
        // baseCase
        if(curY == map.size() - 1 && curX == map[0].size() - 1)
            return cnt;
        
        // 상하좌우 이동
        for(int i = 0 ; i < 4 ; i++) {
            int nextY = curY + dy[i];   int nextX = curX + dx[i];
            // 좌표 안일 경우
            if(nextY >= 0 && nextY < map.size() && 
              nextX >= 0 && nextX < map[0].size()) {
                // 방문을 하지 않았을 경우 그리고 1인 경우
                if(!visited[nextY][nextX] && map[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    q.push(make_tuple(nextY, nextX, cnt + 1));
                }
            }
            
        }
        
    }
    
    
    return -1;
}

int solution(vector<vector<int> > maps)
{

    return bfs(maps);
}