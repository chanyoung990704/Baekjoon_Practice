#include <string>
#include <algorithm>
#include <vector>
#include <set>

using namespace std;

int solution(int m, int n, vector<string> board) {
    int answer = 0;
    bool isErase = true;
    
    while(isErase) {
        
        set<pair<int, int>> set_idx;
        isErase = false;
        
        // 2 x 2 확인
        for(int i = 0 ; i < m - 1 ; i++)
            for(int j = 0 ; j < n - 1 ; j++){
                char cur = board[i][j];
                // 지워지는 경우
                if(cur != ' ' && cur == board[i + 1][j] && cur == board[i + 1][j + 1]
                  && cur == board[i][j + 1]) {
                    set_idx.insert(make_pair(i, j));
                    set_idx.insert(make_pair(i, j + 1));
                    set_idx.insert(make_pair(i + 1, j));
                    set_idx.insert(make_pair(i + 1, j + 1));
                    isErase = true;
                }
            }
        
        
        // 삭제
        for(auto& p : set_idx){
            board[p.first][p.second] = ' ';
            answer++;
        }
        
        
        // 빈공간 채우기
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = m - 1 ; j >= 0 ; j--) {
                // 빈공간 찾은 경우
                if(board[j][i] == ' ') {
                    for(int k = j - 1 ; k >= 0 ; k--) {
                        if(board[k][i] != ' '){
                            swap(board[j][i], board[k][i]);
                            break;
                        }
                    }
                }
            }   
        }
        
        
    }
        
        
    return answer;
}