#include <algorithm>
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    vector<vector<int>> map(5, vector<int>(5, -1));
    unordered_map<int, pair<int, int>> is_occured;

    for(int i = 0 ; i < 5 ; i++)
        for(int j = 0 ; j < 5 ; j++){
            int n;  cin >> n;
            is_occured[n] = make_pair(i, j);
        }

    
    int cnt = 0;
    int bingo = 0;

    for(int i = 0 ; i < 5 ; i++){
        for(int j = 0 ; j < 5 ; j++) {
            int n;  cin >> n;

            int y = is_occured[n].first;
            int x = is_occured[n].second;

            map[y][x] = 1;
            cnt++;

            bool is_x = true;
            bool is_y = true;
            bool is_xy1 = true; // 대각선
            bool is_xy2 = true;

            // 가로 확인
            for(int k = 0 ; k < 5 ; k++){
                if(map[y][k] == -1){
                    is_x = false;
                    break;
                }
            }

            // 세로 확인
            for(int k = 0 ; k < 5 ; k++){
                if(map[k][x] == -1){
                    is_y = false;
                    break;
                }
            }

            // 대각 확인
            if(y == x){
                for(int k = 0 ; k < 5 ; k++){
                    if(map[k][k] == -1){
                        is_xy1 = false;
                        break;
                    }
                }
            }else{
                is_xy1 =false;
            }

            if(y + x == 4){
                for(int k = 0 ; k < 5 ; k++){
                    if(map[k][4 - k] == -1){
                        is_xy2 = false;
                        break;
                    }
                }
            }else{
                is_xy2 = false;
            }

            // 빙고확인
            if(is_x)
                bingo++;
            if(is_y)
                bingo++;
            if(is_xy1)
                bingo++;
            if(is_xy2)
                bingo++;

            if(bingo >= 3){
                cout << cnt << "\n";
                return 0;
            }

        }
    }

}