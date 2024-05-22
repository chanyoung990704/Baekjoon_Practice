#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string X, string Y) {
    string answer = "";
    
    vector<int> x_cnt(10, 0);
    vector<int> x_y_pair;
    
    for(auto& c : X)
        x_cnt[c - '0']++;
    
    for(auto& c : Y){
        int cur = c - '0';
        if(x_cnt[cur] > 0){
            x_cnt[cur]--;
            x_y_pair.push_back(cur);
        }
    }
    
    if(x_y_pair.empty())
        return "-1";
    
    sort(x_y_pair.begin(), x_y_pair.end(), greater<int>());
    
    if(x_y_pair[0] == 0)
        return "0";
    
    for(int i = 0 ; i < x_y_pair.size() ; i++){
        answer.append(to_string(x_y_pair[i]));
    }
    
    return answer;
}