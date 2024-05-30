#include <algorithm>
#include <iostream>
#include <vector>
#include <set>
#include <map>

using namespace std;

bool isPossible(int y, int x, int n, map<pair<int, int>, int>& mine_map){
    return (y >= 0 && y < n && x >= 0 && x < n) && 
    (mine_map.find(make_pair(y,x)) != mine_map.end());
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;  cin >> n;

    map<pair<int, int>, int> mine_map;

    for(int i = 0 ; i < n ; i++){
        string s;   cin >> s;
        for(int j = 0 ; j < n ; j++){
            char cur = s[j];
            if(cur == '*')
                mine_map[make_pair(i,j)] = 1;
        }
    }

    vector<string> result;
    bool is_mine = false;
    for(int i = 0 ; i < n ; i++){
        string s;   cin >> s;
        for(int j = 0 ; j < n ; j++) {
            char cur = s[j];
            int cnt = 0;
    
            if(cur == 'x'){
                // 지뢰 클릭
                if(mine_map.find(make_pair(i, j)) != mine_map.end()){
                    is_mine = true;
                }else{
                    // 8가지 경로에서 지뢰 탐색
                    if(isPossible(i + 1, j, n, mine_map)){
                        cnt++;
                    }
                    if(isPossible(i - 1, j, n, mine_map)){
                        cnt++;
                    }
                    if(isPossible(i, j + 1, n, mine_map)){
                        cnt++;
                    }
                    if(isPossible(i, j - 1, n, mine_map)){
                        cnt++;
                    }
                    if(isPossible(i + 1, j + 1, n, mine_map)){
                        cnt++;
                    }
                    if(isPossible(i - 1, j - 1, n, mine_map)){
                        cnt++;
                    }
                    if(isPossible(i - 1, j + 1, n, mine_map)){
                        cnt++;
                    }
                    if(isPossible(i + 1, j - 1, n, mine_map)){
                        cnt++;
                    }

                    char cnt_c = cnt + '0';
                    s[j] = cnt_c;
                }
            }
        }
        result.push_back(s);
    }

    if(is_mine){
        for(auto& m : mine_map){
            int y = m.first.first;
            int x = m.first.second;

            result[y][x] = '*';
        }
    }

    for(auto& r : result){
        for(auto& c : r)
            cout << c;
        cout << "\n";
    }
}