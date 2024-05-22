#include <string>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    vector<queue<int>> vq(board[0].size() + 1);
    
    for(auto b : board){
        for(int i = 0 ; i < b.size() ; i++)
            if(b[i] != 0)
                vq[i + 1].push(b[i]);
    }
    
    stack<int> st;
    
    for(auto m : moves){
     
        if(!vq[m].empty()){
            int cur = vq[m].front();
            vq[m].pop();
            
            if(!st.empty() && st.top() == cur){
                answer += 2;
                st.pop();
            }else{
                st.push(cur);
            }
            
        }
        
    }
    
    
    return answer;
}