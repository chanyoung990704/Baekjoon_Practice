#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(int k, vector<int> score) {
    vector<int> answer;
    
    priority_queue<int, vector<int>, greater<int>> q;
    for(int i = 0 ; i < score.size() ; i++){
        q.push(score[i]);
        
        if(q.size() == k + 1){
            q.pop();
        }
        
        answer.push_back(q.top());
        
    }
    
    return answer;
}