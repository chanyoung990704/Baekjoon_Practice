#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> board)
{
    int answer = -1;
    
    vector<vector<int>> dp(board.size(), vector<int>(board[0].size(), 0));
    
    for(int i = 0 ; i < board.size() ; i++){
        dp[i][0] = board[i][0];
    }
    
    for(int i = 0 ; i < board[0].size() ; i++){
        dp[0][i] = board[0][i];
    }
    
    for(int i = 1 ; i < board.size() ; i++)
        for(int j = 1 ; j < board[0].size() ; j++){
            if(board[i][j] == 1){
                dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]),
                               dp[i-1][j-1]) + 1;
            }
            answer = max(answer, dp[i][j]);
        }
            


    return answer * answer;
}