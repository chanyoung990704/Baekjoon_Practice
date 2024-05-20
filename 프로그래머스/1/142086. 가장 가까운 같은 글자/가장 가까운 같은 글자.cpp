#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    
    vector<bool> visited(26, false);
    vector<int> idx(26, 0);
    
    for(int i = 0 ; i < s.size() ; i++) {
        
        int cur = s[i] - 'a';
        
        if(!visited[cur]){
            visited[cur] = true;
            idx[cur] = i;
            answer.push_back(-1);
        }else{
            answer.push_back(i - idx[cur]);
            idx[cur] = i;
        }
        
        
    }
    
    
    return answer;
}