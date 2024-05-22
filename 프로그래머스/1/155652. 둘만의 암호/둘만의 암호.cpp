#include <string>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

string solution(string s, string skip, int index) {
    string answer = "";
    
    unordered_set<char> skip_set(skip.begin(), skip.end());
    
    for(auto& c : s){
        
        char cur = c;
        int cnt = 0;
        
        while(cnt < index){
            cur++;
            if(cur > 'z')
                cur = 'a';
            if(skip_set.find(cur) == skip_set.end())
                cnt++;
        }
        
        answer.push_back(cur);
    }
    
    return answer;
}