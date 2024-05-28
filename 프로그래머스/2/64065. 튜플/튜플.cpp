#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <sstream>

using namespace std;

bool cmp(vector<int>& a, vector<int>& b){
    return a.size() < b.size();
}

vector<int> solution(string s) {
    vector<int> answer;

    vector<vector<int>> sets;
    string tmp;
    bool is_start = false;
    for(auto& c : s) {
        
        if(c == '{'){
            is_start = true;
            tmp = "";
            continue;
        }
        
        if((c == ',' || isdigit(c)) && is_start) {
            tmp.push_back(c);
            continue;
        }
        
        
        if(c == '}' && is_start) {
            is_start = false;
            vector<int> set;
            stringstream ss(tmp);
            string token;
            while(getline(ss, token, ',')){
                set.push_back(stoi(token));
            }
            sets.push_back(set);
            
        }
        
    }
    
    sort(sets.begin(), sets.end(), cmp);
    
    for(int i = 0 ; i < sets.size() ; i++) {
        if(i == 0) {
            answer.push_back(sets[0][0]);
            continue;
        }
        
        for(auto& n : sets[i]){
            if(find(answer.begin(), answer.end(), n) == answer.end()){
                answer.push_back(n);
                break;
            }
        }
        
    }
    
    
    return answer;
}