#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <tuple>

using namespace std;

int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

bool isPossible(int y, int x, vector<string>& maps){
    return y >= 0 && y < maps.size() && x >= 0 && x < maps[0].size();
}

int bfs(int y, int x, char c, vector<string>& maps) {
    
    int ret = -1;
    queue<tuple<int, int, int>> q;
    vector<vector<bool>> visited(maps.size(), vector<bool>(maps[0].size(), false));
    
    q.push(make_tuple(y, x, 0));
    visited[y][x] = true;
    
    while(!q.empty()) {
        int cur_y = get<0>(q.front());
        int cur_x = get<1>(q.front());
        int cnt = get<2>(q.front());
        q.pop();
        
        if(maps[cur_y][cur_x] == c){
            ret = cnt;
            break;
        }
        
        for(int i = 0 ; i < 4 ; i++){
            int ny = cur_y + dy[i];
            int nx = cur_x + dx[i];
            
            if(isPossible(ny, nx, maps) && maps[ny][nx] != 'X' 
              && !visited[ny][nx]){
                visited[ny][nx] = true;
                q.push(make_tuple(ny, nx, cnt + 1));
            }
        }
        
    }
    
    return ret;
}

int solution(vector<string> maps) {
    int answer = 0;
    int sy = 0; int sx = 0; int ly = 0; int lx = 0; int ey = 0; int ex = 0;
    
    for(int i = 0 ; i < maps.size() ; i++)
        for(int j = 0 ; j < maps[0].size() ; j++){
            if(maps[i][j] == 'S'){
                sy = i;
                sx = j;
            }
            else if(maps[i][j] == 'L'){
                ly = i;
                lx = j;
            }else if(maps[i][j] == 'E'){
                ey = i;
                ex = j;
            }
        }
    
    // 시작점에서 레버까지 bfs
    int ret1 = bfs(sy, sx, 'L', maps);
    if(ret1 == -1)
        return ret1;
    else
        answer += ret1;
    
    // 레버에서 끝점
    int ret2 = bfs(ly, lx, 'E', maps);
    if(ret2 == -1)
        return ret2;
    else
        answer += ret2;
    
    
    return answer;
}