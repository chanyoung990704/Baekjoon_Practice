#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    
    int max_val = 1e9;
    vector<int> dp(26, max_val);
    
    for(auto& cur_s : keymap){
        
        int cnt = 1;
        for(int i = 0 ; i < cur_s.size() ; i++){
            int cur = (cur_s[i] - 'A');
            dp[cur] = min(dp[cur], cnt);
            cnt++;
        }
        
        
    }
    
    
    for(auto& cur_s : targets){
        int val = 0;
        for(auto& c : cur_s){
            int cur = c - 'A';
            if(dp[cur] == max_val){
                val = -1;
                break;
            }else{
                val += dp[cur];
            }
        }
        
        answer.push_back(val);
    }
    
    
    
    return answer;
}