#include <string>
#include <vector>
#include <algorithm>
#include <cmath> // cmath로 수정

using namespace std;

int get_dist(vector<pair<int, int>>& cur) {
    return abs(cur.front().first - cur.back().first) +
        abs(cur.front().second - cur.back().second);
}

bool isPossible(vector<string>& place, vector<pair<int, int>>& idx) {
    
    vector<bool> visited(idx.size(), false);
    fill(visited.begin(), visited.begin() + 2, true);
    
    do {
        vector<pair<int, int>> cur;
        for (int i = 0; i < visited.size(); i++) {
            if (visited[i]) {
                cur.push_back(idx[i]);
            }
        }
        
        // 맨해튼 거리
        int dist = get_dist(cur);
        
        if (dist == 1) {
            return false;
        } else if (dist == 2) {
            int y1 = cur[0].first;
            int x1 = cur[0].second;
            int y2 = cur[1].first;
            int x2 = cur[1].second;
            
            // y가 같은 경우
            if (y1 == y2) {
                int x = min(x1, x2) + 1;
                if (place[y1][x] != 'X') {
                    return false;
                }
            // x가 같은 경우
            } else if (x1 == x2) {
                int y = min(y1, y2) + 1;
                if (place[y][x1] != 'X') {
                    return false;
                }
            // 대각일 경우
            } else {
                if (place[y1][x2] != 'X' || place[y2][x1] != 'X') {
                    return false;
                }
            }
        }
        
    } while (prev_permutation(visited.begin(), visited.end()));
    
    return true;
}

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    
    for (auto& place : places) {
        
        vector<pair<int, int>> idx;
        for (int i = 0; i < place.size(); i++) {
            for (int j = 0; j < place[0].size(); j++) {
                if (place[i][j] == 'P') {
                    idx.push_back(make_pair(i, j));
                }
            }
        }
        
        if (idx.empty()) {
            answer.push_back(1); // 사람이 없으면 거리두기 지켜짐
            continue;
        }

        sort(idx.begin(), idx.end());
        if (isPossible(place, idx)) {
            answer.push_back(1);
        } else {
            answer.push_back(0);
        }
    }
    
    return answer;
}
