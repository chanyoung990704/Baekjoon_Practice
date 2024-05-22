#include <string>
#include <vector>

using namespace std;

int dy[4] = {0, 0, -1, 1};
int dx[4] = {-1, 1, 0, 0};

int solution(vector<vector<string>> board, int h, int w) {
    int answer = 0;
    
    string cur_color = board[h][w];
    
    for(int i = 0 ; i < 4 ; i++) {
        int next_h = h + dy[i];
        int next_w = w + dx[i];
        if(next_h >= 0 && next_h < board.size() && next_w >= 0 && next_w < board[0].size()){
            if(cur_color == board[next_h][next_w])
                answer++;
        }
        
        
    }
    
    return answer;
}