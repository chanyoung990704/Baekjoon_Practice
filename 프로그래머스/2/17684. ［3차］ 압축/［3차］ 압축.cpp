#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<int> solution(string msg) {
    vector<int> answer;
    
    unordered_map<string, int> msg_map;
    for(int i = 0 ; i < 26 ; i++){
        char c = 'A' + i;
        string t;
        t.push_back(c);
        msg_map[t] = i + 1;
    }
    
    int next_idx = 27;
    int i = 0;
    
    while(i < msg.size()) {
        
        string w;
        int j = i;
        
        while(j < msg.size() && msg_map.find(msg.substr(i, j - i + 1)) != msg_map.end()){
            w = msg.substr(i, j - i + 1);
            j++;
        }
        
        answer.push_back(msg_map[w]);
        
        if(j < msg.size()){
            msg_map[msg.substr(i, j - i + 1)] = next_idx++;
        }
        
        i += w.size();
        
    }
    
    
    
    
    return answer;
}