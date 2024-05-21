#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

bool isValid(string bab, unordered_set<string>& validWords){
    string prev = "";
    string cur = "";
    
    for(auto c : bab){
        cur += c;
        if(validWords.find(cur) != validWords.end() && cur != prev){
            prev = cur;
            cur = "";
        }
    }
    
    return cur.empty();
}

int solution(vector<string> babbling) {
    int answer = 0;
    unordered_set<string> validWords = {"aya", "ye", "woo", "ma"};
    for(auto bab : babbling)
        if(isValid(bab, validWords))
            answer++;
    return answer;
}